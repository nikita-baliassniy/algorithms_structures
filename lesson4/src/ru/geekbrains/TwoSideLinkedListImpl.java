package ru.geekbrains;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E> {

    private DoubleLinkNode<E> firstElement;
    private DoubleLinkNode<E> lastElement;

    @Override
    public void insertLast(E value) {
        DoubleLinkNode<E> newNode = new DoubleLinkNode<>(value, null, null);
        if (isEmpty()) {
            firstElement = newNode;
        } else {
            lastElement.next = newNode;
            newNode.previous = lastElement;
        }
        lastElement = newNode;
        size++;
    }

    @Override
    public void insertFirst(E value) {
        DoubleLinkNode<E> newNode = new DoubleLinkNode<>(value, null, null);
        newNode.next = firstElement;

        if (firstElement != null) {
            firstElement.previous = newNode;
        }
        firstElement = newNode;
        size++;
        if (size == 1) {
            lastElement = firstElement;
        }
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        DoubleLinkNode<E> removedNode = firstElement;
        if (size == 1) {
            lastElement = null;
            firstElement = null;
        } else {
            firstElement = removedNode.next;
            firstElement.previous = null;
        }
        removedNode.next = null;
        size--;
        return removedNode.item;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        DoubleLinkNode<E> removedNode = lastElement;
        if (size == 1) {
            lastElement = null;
            firstElement = null;
        } else {
            lastElement = lastElement.previous;
            lastElement.next = null;
        }
        size--;
        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        DoubleLinkNode<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            current = current.next;
        }
        if (current == null) {
            return false;
        } else if (current == firstElement) {
            removeFirst();
            return true;
        } else if (current == lastElement) {
            removeLast();
            return true;
        } else {
            current.previous.next = current.next;
            current.previous = null;
            current.next = null;
            size--;
            return true;
        }
    }

    @Override
    public E getLast() {
        return getValue(lastElement);
    }

    @Override
    public E getFirst() {
        return getValue(firstElement);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        DoubleLinkNode<E> current = firstElement;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean contains(E value) {
        DoubleLinkNode<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

}
