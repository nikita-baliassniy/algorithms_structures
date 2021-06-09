package ru.geekbrains;

public interface Tree<E extends Comparable<? super E>> {

    int getHeight(Node<E> node);

    boolean isTreeBalanced();

    boolean isBalanced(Node<E> node);

    int getDeep(E value);

    enum TraverseMode {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER,
    }

    boolean add(E value);

    boolean contains(E value);

    boolean remove(E value);

    boolean isEmpty();

    int size();

    void display();

    void traverse(TraverseMode mode);
}
