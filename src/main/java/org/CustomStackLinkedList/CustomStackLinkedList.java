package org.CustomStackLinkedList;

import java.util.EmptyStackException;

public class CustomStackLinkedList<T> implements Stack<T> {

    private Node head;
    int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        if(size == 0)
            throw new EmptyStackException();
        return head.data;
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T headValue = head.data;
        head = head.nextNode;
        size--;
        return headValue;
    }

    public T push(T item) {
        Node newHead = new Node(item);
        newHead.nextNode = head;
        head = newHead;
        size++;
        return item;
    }

    public int search(Object item) {
        int index = 0;
        for (Node x = head; x != null; x = x.nextNode, index++)
            if (x.data == item)
                return size - index - 1;
        return -1;
    }

    public int getSize() {
        return size;
    }

    private class Node {

        private T data;
        private Node nextNode;

        public Node(T data) {
            this.data = data;
        }
    }
}
