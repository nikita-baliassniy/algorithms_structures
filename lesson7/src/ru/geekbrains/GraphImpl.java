package ru.geekbrains;


import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final boolean[][] adjMat;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>();
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(startLabel, secondLabel);
        for (String another : others) {
            result &= addEdge(startLabel, another);
        }
        return result;
    }

    private boolean addEdge(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMat[startIndex][endIndex] = true;
        adjMat[endIndex][startIndex] = true;
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            Vertex vertex = vertexList.get(i);
            if (vertex.getLabel().equals(label)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label: " + startLabel);
        }
        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);
        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
        resetVertexState();
    }

    private void resetVertexState() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel());
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.println(vertex.getLabel());
        queue.add(vertex);
        vertex.setVisited(true);
    }

    @Override
    public List<String> shortestPast(String startLabel, String endLabel) {
        int pathLength = adjMat.length * adjMat.length;
        List<String> path = new ArrayList<>();
        List<Vertex> stack = new ArrayList<>();
        int startIndex = indexOf(startLabel);
        int finalIndex = indexOf(endLabel);
        if (startIndex == -1 || finalIndex == -1) {
            throw new IllegalArgumentException("Invalid start or end label");
        }
        Vertex vertex = vertexList.get(startIndex);
        vertex.setVisited(true);
        stack.add(vertex);
        Vertex finalVertex = vertexList.get(indexOf(endLabel));
        for (int i = 0; i < adjMat.length * adjMat.length; i++) {
            if (!stack.isEmpty()) {
                vertex = getNearUnvisitedVertex(stack.get(stack.size() - 1));
                if (vertex != null) {
                    stack.add(vertex);
                    vertex.setVisited(true);
                    if (vertex == finalVertex) {
                        if (stack.size() < pathLength) {
                            path = new ArrayList<>();
                            for (Vertex currentVertex : stack) {
                                path.add(currentVertex.getLabel());
                            }
                            pathLength = path.size();
                        }
                        stack.remove(stack.size() - 1);
                    } else {
                        if (finalVertex.isVisited()) {
                            finalVertex.setVisited(false);
                        }
                    }
                } else {
                    stack.remove(stack.size() - 1);
                }
            }
        }
        resetVertexState();
        return path;
    }

    private Vertex getNearUnvisitedVertex(Vertex current) {
        int currentIndex = vertexList.indexOf(current);
        for (int i = 0; i < getSize(); i++) {
            if (adjMat[currentIndex][i] && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label: " + startLabel);
        }
        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);
        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
        resetVertexState();
    }
}