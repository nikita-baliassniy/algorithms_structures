package ru.geekbrains;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    private final Item<K, V> emptyItem = new Item<>(null, null, null);

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;
        private Item<K, V> next;

        public Item(K key, V value, Item<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private final Item<K, V>[] data;
    private int size;

    public HashTableImpl(int initialCapacity) {
        this.data = new Item[initialCapacity];
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);
        if (data[index] != null && data[index] != emptyItem) {
            Item<K, V> current = data[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Item<>(key, value, null);
        } else {
            data[index] = new Item<>(key, value, null);
        }
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        Item<K, V> current = data[index];
        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.getValue();
            } else {
                current = current.next;
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);
        Item<K, V> previous = data[index];
        Item<K, V> current = previous.next;
        V valueToDelete = null;
        if (previous.getKey().equals(key)) {
            data[index] = previous.next;
            previous.next = null;
            valueToDelete = previous.getValue();
        } else {
            while (current != null) {
                if (current.getKey().equals(key)) {
                    previous.next = current.next;
                    current.next = null;
                    valueToDelete = current.getValue();
                    break;
                } else {
                    previous = previous.next;
                    current = previous.next;
                }
            }
        }
        if (valueToDelete != null) {
            size--;
        }
        return valueToDelete;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            System.out.print(i + " : ");
            Item<K, V> current = data[i];
            while (current != null) {
                System.out.print(current.getKey() + " - " + current.getValue() + "; ");
                current = current.next;
            }
            System.out.println();
        }
        System.out.println("----------");
    }
}