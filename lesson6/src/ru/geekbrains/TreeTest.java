package ru.geekbrains;

import java.util.Random;

public class TreeTest {

    public static void main(String[] args) {
        int arraySize = 20;
        int balanced = 0;
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            Tree<Integer> currentTree = new TreeImpl<>(4);
            for (int j = 0; j < Math.pow(2, 4) - 1; j++) {
                currentTree.add(random.nextInt(50) - 25);
            }
            if (currentTree.isTreeBalanced()) {
                balanced++;
                System.out.println("Balanced Tree:");
            } else {
                System.out.println("Unbalanced Tree:");
            }
            currentTree.display();
        }
        System.out.println("There are " + balanced + " balanced trees from " + arraySize);
    }
}

