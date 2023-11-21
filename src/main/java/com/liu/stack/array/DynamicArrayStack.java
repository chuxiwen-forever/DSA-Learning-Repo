package com.liu.stack.array;

import com.liu.stack.DynamicStack;

import java.util.ArrayList;
import java.util.List;

public class DynamicArrayStack<E> implements DynamicStack<E> {

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
    public void push(E element) {
        list.add(element);
    }

    @Override
    public E pop() {
        return list.remove(list.size() - 1);
    }

    @Override
    public E top() {
        return list.get(list.size() - 1);
    }

    @Override
    public void clear() {
        list.clear();
    }
}
