package com.liu.queue.array;

import com.liu.queue.DynamicQueue;

import java.util.ArrayList;
import java.util.List;

public class DynamicArrayQueue<E> implements DynamicQueue<E> {
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
    public void enQueue(E element) {
        list.add(element);
    }

    @Override
    public E deQueue() {
        return list.remove(0);
    }

    @Override
    public E front() {
        return list.get(0);
    }
}
