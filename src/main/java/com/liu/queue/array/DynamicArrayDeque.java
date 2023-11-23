package com.liu.queue.array;

import com.liu.queue.DynamicDeque;

import java.util.ArrayList;
import java.util.List;

public class DynamicArrayDeque<E> implements DynamicDeque<E> {
    private final List<E> list = new ArrayList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public void enQueueRear(E element) {
        list.add(element);
    }

    @Override
    public E deQueueRear() {
        return list.remove(list.size() - 1);
    }

    @Override
    public void enQueueFront(E element) {
        list.add(0, element);
    }

    @Override
    public E deQueueFront() {
        return list.remove(0);
    }

    @Override
    public E front() {
        return list.get(0);
    }

    @Override
    public E Rear() {
        return list.get(list.size() - 1);
    }
}
