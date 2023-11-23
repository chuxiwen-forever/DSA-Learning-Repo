package com.liu.queue;

public interface DynamicDeque<E> {
    int size();

    boolean isEmpty();

    void clear();

    // 从队尾入队
    void enQueueRear(E element);

    // 从队尾出队
    E deQueueRear();

    // 从队头入队
    void enQueueFront(E element);

    // 从队头出队
    E deQueueFront();

    // 获得队头元素
    E front();

    // 获得队尾元素
    E Rear();
}
