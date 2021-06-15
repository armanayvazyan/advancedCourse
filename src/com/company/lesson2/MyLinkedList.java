package com.company.lesson2;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MyLinkedList<T> implements MyList<T> {

    public Node<T> begin;
    private int size;

    @Override
    public void add(T obj) {
        if(begin == null) {
            begin = new Node<>(obj);
        } else {
            getNode(size-1).next = new Node<>(obj);
        }
        size++;
    }

    private Node<T> getNode(int i) {
        Node<T> cursor = begin;
        int count = 0;
        while (count < i) {
            cursor = cursor.next;
            count++;
        }
        return cursor;
    }

    private void checkIndex(int i) {
        if(i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(i);
        }
    }

    @Override
    public T get(int i) {
        checkIndex(i);
        return getNode(i).data;
    }

    @Override
    public void remove(int i) {
        checkIndex(i);
        if( i == 0) {
            begin = begin.next;
            size--;
            return;
        }
        Node<T> node = getNode(i-1);
        node.next = node.next.next;
        size--;
    }

    @Override
    public void remove(T obj) {
        Node<T> cursor = begin;
        if (cursor == null)
            return;
        if (Objects.equals(cursor.data, obj)) {
            begin = begin.next;
            size--;
            return;
        }
        Node<T> prev;
        while (cursor != null) {
            prev = cursor;
            cursor = cursor.next;
            if(cursor!=null && Objects.equals(cursor.data, obj)) {
                prev.next = cursor.next;
                size--;
                return;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node<T> cursor = begin;
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(cursor.data.toString());
            if(i != size - 1){
                stringBuilder.append(", ");
            }
            cursor = cursor.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public boolean compare(Node<T> begin2) {
        boolean hasNext = true;
        boolean areEqual;
        if(begin2 == null && begin == null){
            return true;
        }
        do {
            if(begin2 == null ^ begin == null){
                areEqual = false;
                break;
            }
            else if(begin2 == null && begin == null){
                areEqual = true;
                break;
            }
            areEqual = begin2.data.equals(begin.data);
            if(!areEqual) {
                hasNext = false;
            }
            begin2 = begin2.next;
            begin = begin.next;
        }
        while (hasNext);
        return areEqual;
    }

    public void merge(Node<T> begin2) {
        boolean hasNext = true;
        if(begin2 == null && begin == null){
            return;
        }
        do {
            if(begin2.data.equals(begin.data)) {

            }

        } while (hasNext);

    }

    public Node<T> reverse(Node<T> llist) {
        if(llist == null || llist.next == null) {
            return llist;
        }
        MyLinkedList<T> list1 = new MyLinkedList<T>();
        Node<T> node = llist;
        int size = 0;
        while(true) {
            list1.add(node.data);
            if(node.next != null) {
                node = node.next;
                size++;
            }
            else
                break;
        }
        MyLinkedList<T> list2 = new MyLinkedList<T>();

        for(int j = 0 ; j <= size; j++) {
            Node<T> node1 = llist;
            for (int i = 0; i < size - j ; i++) {
                if(node1.next != null) {
                    node1 = node1.next;
                }
            }
            list2.add(node1.data);
        }
        return list2.begin;


    }

    public T getNodeValue(Node<T> llist, int positionFromTail) {

        MyLinkedList<T> list1 = new MyLinkedList<T>();
        Node<T> node = llist;
        int size = 0;
        while(true) {
            list1.add(node.data);
            if(node.next != null) {
                node = node.next;
                size++;
            }
            else
                break;
        }

        Node<T> node1 = llist;
        for (int i = 0; i <= size - positionFromTail -1 ; i++) {
            if(node1.next != null)
                node1 = node1.next;
        }
        return node1.data;
    }

    public Node<T> removeDuplicated(Node<T> llist) {

        MyLinkedList<T> a =new MyLinkedList<>();
        Node<T> curr = llist;
        while (curr != null) {
            Node<T> temp = curr;
            while(temp!=null && temp.data==curr.data) {
                temp = temp.next;
            }
            a.add(curr.data);
            curr.next = temp;
            curr = curr.next;
        }

        return a.begin;
    }
}
