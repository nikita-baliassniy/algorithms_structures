package ru.geekbrains;

public class Main {

    public static void main(String[] args) {
        testDoubleLinkedList();
        testForEach();
    }

    private static void testDoubleLinkedList() {
        TwoSideLinkedList<Integer> linkedList = new TwoSideLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertLast(5);

        linkedList.display();

        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));

        linkedList.remove(2);
        linkedList.removeFirst();
        linkedList.display();
        linkedList.removeLast();
        linkedList.display();
    }

    private static void testForEach() {
        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);

        linkedList.display();
        for (Integer value : linkedList) {
            System.out.println(value);
        }
    }
}
