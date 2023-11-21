package com.liu.dynamic.circlelinked;

import com.liu.dynamic.AbstractDynamicList;

@SuppressWarnings("all")
public class DynamicCircleLinkedList<E> extends AbstractDynamicList<E> {

    private Node<E> first;
    private Node<E> last;
    private Node<E> current;

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
        if (index == size) {
            Node<E> oldLast = last;
            last = new Node<>(element, oldLast, first);
            if (oldLast == null) {
                first = last;
                first.next = first;
                first.prev = first;
            } else {
                oldLast.next = last;
                first.prev = last;
            }
        } else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(element, prev, next);
            next.prev = node;
            prev.next = node;
            if (next == first) {
                first = node;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        return remove(node(index));
    }

    public E remove(Node<E> node) {
        if (size == 1) {
            first = null;
            last = null;
        } else {
            Node<E> prev = node.prev;
            Node<E> next = node.next;
            prev.next = next;
            next.prev = prev;

            if (node == first) {
                first = next;
            }

            if (node == last) {
                last = prev;
            }
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
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    public E remove() {
        if (current == null) return null;
        Node<E> next = current.next;
        E element = remove(current);
        if (size == 0) {
            current = null;
        } else {
            current = next;
        }
        return element;
    }


    public void reset() {
        current = first;
    }

    public E next() {
        if (current == null) return null;
        current = current.next;
        return current.element;
    }

    private Node<E> node(int index) {
        checkIndex(index);
        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
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

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            if (prev != null) {
                builder.append(prev.element);
            } else {
                builder.append("null");
            }
            builder.append("_").append(element).append("_");
            if (next != null) {
                builder.append(next.element);
            } else {
                builder.append("null");
            }
            return builder.toString();
        }
    }
}
