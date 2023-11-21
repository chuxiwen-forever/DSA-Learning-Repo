package com.liu.stack;

public interface DynamicStack<E> {
    int size();

    boolean isEmpty();

    void push(E element);

    E pop();

    E top();

    void clear();
}
