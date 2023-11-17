package com.liu.dynamic;

public interface DynamicList<E> {
    // 返回数组大小
    int size();

    // 判断数组是否为空
    boolean isEmpty();

    // 判断数组中是否存在目标元素
    boolean contains(E element);

    // 添加元素
    void add(E element);

    // 获取指定索引的值
    E get(int index);

    // 给指定的位置进行赋予属性，并返回原数据
    E set(int index, E element);

    // 在指定位置添加数据
    void add(int index, E element);

    // 移除指定位置的元素，并返回元素
    E remove(int index);

    // 返回某一个元素的索引
    int indexOf(E element);

    // 清空列表
    void clear();
}
