package com.liu.dynamic;

public abstract class AbstractDynamicList<E> implements DynamicList<E> {
    protected int size;


    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException(String.format("Index is %s, But size is %s", index, size));
    }

    protected void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    protected void checkIndex(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
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
    public void add(E element) {
        add(size, element);
    }
}
