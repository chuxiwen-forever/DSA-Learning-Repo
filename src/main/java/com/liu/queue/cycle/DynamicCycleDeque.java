package com.liu.queue.cycle;

import com.liu.queue.DynamicDeque;

@SuppressWarnings("all")
public class DynamicCycleDeque<E> implements DynamicDeque<E> {

    private int front;
    private int size;
    private E elements[];
    private static final int DEFAULT_CAPACITY = 10;

    public DynamicCycleDeque() {
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
        front = 0;
        size = 0;
    }

    @Override
    public void enQueueRear(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    @Override
    public E deQueueRear() {
        int rearIndex = index(size - 1);
        E rear = elements[rearIndex];
        elements[rearIndex] = null;
        size--;
        return rear;
    }

    @Override
    public void enQueueFront(E element) {
        ensureCapacity(size + 1);
        front = index(-1);
        elements[front] = element;
        size++;
    }

    @Override
    public E deQueueFront() {
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }

    @Override
    public E front() {
        return elements[front];
    }

    @Override
    public E Rear() {
        return elements[index(size - 1)];
    }

    private int index(int index) {
//        return (front + index) % elements.length;
//        避免乘, 除, 模, 浮点等计算
        index += front;
        if (index < 0) {
            return index + elements.length;
        }
//        return index % elements.length;
        return index - ((index >= elements.length) ? elements.length : 0);
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
        front = 0;
    }
}
