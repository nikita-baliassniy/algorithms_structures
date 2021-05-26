package ru.geekbrains;

import ru.geekbrains.queue.Deque;
import ru.geekbrains.queue.DequeImpl;
import ru.geekbrains.stack.Stack;
import ru.geekbrains.stack.StackImpl;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        testDeque();
//        stringReverse(testString);
    }

    /**
     * Тест для класса деки
     * */
    private static void testDeque() {

        Deque<Integer> deque = new DequeImpl<>(5);
        deque.insertLeft(3);
        deque.insertRight(5);
        deque.insertLeft(1);
        deque.insertRight(2);
        deque.insertLeft(6);
        System.out.println(deque.insertRight(4));

        deque.display();

        System.out.println("Queue peek front: " + deque.peekFront());
        System.out.println("Queue peek back: " + deque.peekBack());
        System.out.println("Queue size: " + deque.size());
        System.out.println("Queue is full: " + deque.isFull());

        while (!deque.isEmpty()) {
            System.out.println(deque.removeRight());
            deque.display();
        }
    }

    /**
     *   Вывод получаемой строки в обратном виде
     */

    private static void stringReverse() {
        Scanner scanner = new Scanner(System.in);
        int stringLength = 0;
        while (stringLength <= 0) {
            System.out.println("Enter the string length > 0, please");
            stringLength = scanner.nextInt();
        }
        System.out.println("Enter your string by 1 char at a time, please");
        Stack<Character> stack = new StackImpl<>(stringLength);
        for (int i = 0; i < stringLength; i++) {
            char currentChar = scanner.next().charAt(0);
            stack.push(currentChar);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    private static Integer removeFromStack(Stack<Integer> stack) {
        return !stack.isEmpty() ? stack.pop() : null;
    }

    private static boolean addToStack(Stack<Integer> stack, Integer value) {
        if (!stack.isFull()) {
            stack.push(value);
            return true;
        }
        return false;
    }
}

