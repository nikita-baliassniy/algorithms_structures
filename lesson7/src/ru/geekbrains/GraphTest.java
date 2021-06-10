package ru.geekbrains;


public class GraphTest {

    public static void main(String[] args) {
        testShortestPath();
    }

    private static void testShortestPath() {
        Graph graph = new GraphImpl(11);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Воронеж");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");

        graph.addEdge("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Липецк", "Воронеж");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Саратов", "Воронеж");
        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Орел", "Курск");
        graph.addEdge("Курск", "Воронеж");

        System.out.println(graph.shortestPast("Липецк", "Рязань"));
        System.out.println(graph.shortestPast("Тула", "Тамбов"));
        System.out.println(graph.shortestPast("Москва", "Воронеж"));
        System.out.println(graph.shortestPast("Курск", "Тамбов"));
    }

}

