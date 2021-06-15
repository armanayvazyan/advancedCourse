package com.company.lesson2;

public interface MyList<T> {

    void add(T obj);
    T get(int i);
    void remove(int i);
    void remove(T obj);
    int size();
}
