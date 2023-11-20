package com.liu.dynamic.singlelinked;

import com.liu.dynamic.AbstractDynamicList;

// 单向链表
public class DynamicSingleLinkedList<E> extends AbstractDynamicList<E> {

    private Node<E> first;

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        E old = node(index).element;
        node(index).element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        checkIndexForAdd(index);
        if (index == 0) {
            first = new Node<>(element, first);
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        Node<E> node = first;
        if (index == 0) {
            first = first.next;
        } else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (node.element.equals(element)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[size=").append(size).append(", ");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) builder.append(", ");
            builder.append(node.element);
            node = node.next;
        }
        builder.append("]");
        return builder.toString();
    }

    private Node<E> node(int index) {
        checkIndex(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
