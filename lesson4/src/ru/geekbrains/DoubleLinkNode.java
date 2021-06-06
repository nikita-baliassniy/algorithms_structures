package ru.geekbrains;

public class DoubleLinkNode<E> extends Node<E> {

    public DoubleLinkNode<E> previous;
    public DoubleLinkNode<E> next;

    public DoubleLinkNode(E item, DoubleLinkNode<E> next, DoubleLinkNode<E> previous) {
        this.item = item;
        this.next = next;
        this.previous = previous;
    }
}
