package com.company.lesson2;

public class MyArrayList<T> implements MyList<T>{

    private static final int CAPACITY = 4;
    private Object[] data;

    private int capacity;
    private int index;

    public MyArrayList() {
        data = new Object[CAPACITY];
        capacity = CAPACITY;
    }

    @Override
    public void add(T obj) {
        if(index == capacity){
            increaseSize();
        }
        data[index++] = obj;
    }

    private void increaseSize() {
        capacity = capacity + CAPACITY;
        Object[] newData = new Object[capacity];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int i) {
        checkIndex(i);
        return (T) data[i];
    }

    private void checkIndex(int i) {
        if(i < 0 || i >= index) {
            throw new IndexOutOfBoundsException(i);
        }
    }

@Override
public void remove(int i) {
    checkIndex(i);
    for (int j = i; j < index - 1; j++) {
        data[j] = data[j + 1]; 
    }
    data[index - 1] = null; 
    index--;             
}

   @Override
   public void remove(T obj) {
    for (int i = 0; i < index; i++) {
        if ((obj == null && data[i] == null) || (obj != null && obj.equals(data[i]))) {
            for (int j = i; j < index - 1; j++) {
                data[j] = data[j + 1];
            }
            data[index - 1] = null;
            index--;
            return;
        }
    }
}

    @Override
    public int size() {
        return index;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < index; i++) {
            stringBuilder.append(data[i]);
            if(i != index - 1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
