package ru.geekbrains;

public class BackpackExample {

    private static final int[] points = new int[]{7, 2, 4, 3, 20, 9, 1};
    private static final int[] weights = new int[]{3, 1, 4, 0, 11, 5, 1};

    public static void main(String[] args) {
        int maxWeight = 10;
        System.out.println("MaxPoints = " + fillBackpack(0, maxWeight)); // 7 + 2 + 3 + 9 + 1 // 3 + 1 + 0 + 5 + 1
    }

    private static int fillBackpack(int index, int currentWeight) {
        if (index >= points.length) {
            return 0;
        } else if (weights[index] > currentWeight) {
            return fillBackpack(index + 1, currentWeight);
        } else {
            return Math.max(fillBackpack(index + 1, currentWeight),
                    fillBackpack(index + 1, currentWeight - weights[index]) + points[index]);
        }
    }
}
