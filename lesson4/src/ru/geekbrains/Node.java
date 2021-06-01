package ru.geekbrains;

public class Node <E> {
    public E item;
    public Node<E> next;

    public Node(){}

    public Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
    }
}
