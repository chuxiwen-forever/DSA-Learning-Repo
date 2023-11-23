package com.liu.queue.cycle;

import com.liu.queue.DynamicQueue;

@SuppressWarnings("all")
public class DynamicCycleQueue<E> implements DynamicQueue<E> {

    private int front;

    private int size;

    private E elements[];

    public static final int DEFAULT_CAPACITY = 10;

    public DynamicCycleQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
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
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[index(i)] = null;
        }
        size = 0;
        front = 0;
    }

    @Override
    public void enQueue(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    @Override
    public E deQueue() {
        E fronElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return fronElement;
    }

    @Override
    public E front() {
        return elements[front];
    }

    // 当front到队尾时，回到队首
    private int index(int index) {
//        return (front + index) % elements.length;
//        避免乘, 除, 模, 浮点等计算
        index += front;
        return index - ((index >= elements.length) ? elements.length : 0);
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(i + front) % elements.length];
        }
        elements = newElements;
        front = 0;
    }
}
