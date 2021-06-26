package com.company.lesson6.homework;

import java.io.*;

public class SerializableSingleton implements Serializable {

    private static volatile SerializableSingleton instance;
    private String host;
    private transient String password;

    private SerializableSingleton() {

    }

    public static SerializableSingleton getInstance() {
        if (instance == null) {
            synchronized (SerializableSingleton.class) {
                if (instance == null) {
                    instance = new SerializableSingleton();
                }
            }
        }
        return instance;
    }

    protected Object readResolve() {
        return getInstance();
    }
}

class Main {

    public static void main(String[] args) {

        SerializableSingleton singleton = SerializableSingleton.getInstance();

        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("serialized"))) {
            out.writeObject(singleton);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SerializableSingleton deserializedSingleton = null;

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("serialized"))) {
            deserializedSingleton = (SerializableSingleton) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println(singleton.hashCode());
        System.out.println(deserializedSingleton.hashCode());

    }
}
