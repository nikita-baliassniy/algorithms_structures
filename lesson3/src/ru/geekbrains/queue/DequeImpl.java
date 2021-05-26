package ru.geekbrains.queue;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {

    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }
        if (head == HEAD_DEFAULT) {
            head = data.length;
        }
        data[--head] = value;
        size++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        return super.insert(value);
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }
        E value = data[tail--];
        if (tail == TAIL_DEFAULT) {
            tail = data.length - 1;
        }
        size--;
        return value;
    }

    @Override
    public E peekBack() {
        return data[tail];
    }

    @Override
    public void display() {
        for (E datum : data) {
            System.out.print(datum + " ");
        }
        System.out.println();
        System.out.println("HEAD INDEX" + head);
        System.out.println("TAIL INDEX" + tail);
    }

}
