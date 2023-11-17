package com.liu.dynamic.array;


public class DynamicIntArrayList {

    private int size;
    private int[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    private static final int ELEMENT_NOT_FOUND = -1;

    public DynamicIntArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicIntArrayList(int capacity) {
        elements = new int[Math.max(capacity, DEFAULT_CAPACITY)];
    }

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public boolean contains(int element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }


    public void add(int element) {
        add(size, element);
    }


    public int get(int index) {
        checkIndex(index);
        return elements[index];
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException(String.format("Index is %s, But size is %s", index, size));
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        int newCapacity = oldCapacity + (oldCapacity >> 1);
        int[] newElements = new int[newCapacity];
        if (size >= 0) System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }


    public int set(int index, int element) {
        int oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }


    public void add(int index, int element) {
        checkIndexForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }


    public int remove(int index) {
        checkIndex(index);
        int oldElement = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        return oldElement;
    }


    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (element == elements[i]) return i;
        }
        return ELEMENT_NOT_FOUND;
    }


    public void clear() {
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            builder.append(elements[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
