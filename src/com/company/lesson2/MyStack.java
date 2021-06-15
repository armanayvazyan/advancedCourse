package com.company.lesson2;

import java.util.EmptyStackException;

public class MyStack<T> {

    private MyArrayList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(T obj) {
        list.add(obj);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public T peek() {
        if(isEmpty()){
           throw new EmptyStackException();
        }
        return list.get(list.size() -1);
    }

    public T pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int lastIndex = list.size() -1;
        T t = list.get(lastIndex);
        list.remove(lastIndex);
        return t;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = list.size() -1; i >=0; i--) {
            sb.append(list.get(i));
            if(i != 0) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }
}
