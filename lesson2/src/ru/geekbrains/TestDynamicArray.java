package ru.geekbrains;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestDynamicArray {

    public static void main(String[] args) {
        int arraySize = 100000;
        Array<Integer> dataForInsert = new ArrayImpl<>(arraySize);
        Array<Integer> dataForBubble = new ArrayImpl<>(arraySize);
        Array<Integer> dataForSelect = new ArrayImpl<>(arraySize);

        Random random = new Random();
        long startTime, endTime;
        for (int i = 0; i < arraySize; i++) {
            dataForInsert.add(random.nextInt(arraySize));
            dataForBubble.add(random.nextInt(arraySize));
            dataForSelect.add(random.nextInt(arraySize));
        }

        System.out.println("BUBBLE SORTING START");
        startTime = System.nanoTime();
        dataForBubble.displayPartial();
        dataForBubble.sortBubble();
        endTime = System.nanoTime();
        dataForBubble.displayPartial();
        System.out.println("BUBBLE SORTING FINISH: TAKES " +
                TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");

        System.out.println("SELECT SORTING START");
        startTime = System.nanoTime();
        dataForSelect.displayPartial();
        dataForSelect.sortSelect();
        endTime = System.nanoTime();
        dataForSelect.displayPartial();
        System.out.println("SELECT SORTING FINISH: TAKES " +
                TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");

        System.out.println("INSERT SORTING START");
        startTime = System.nanoTime();
        dataForInsert.displayPartial();
        dataForInsert.sortInsert();
        endTime = System.nanoTime();
        dataForInsert.displayPartial();
        System.out.println("INSERT SORTING FINISH: TAKES " +
                TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");

    }
}
