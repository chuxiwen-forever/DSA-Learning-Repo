package com.liu.queue;

public interface DynamicQueue<E> {
    int size();
    boolean isEmpty();
    void clear();
    // 入队
    void enQueue(E element);
    // 出队
    E deQueue();
    // 获得头数据
    E front();
}
