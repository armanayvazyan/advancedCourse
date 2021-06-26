package com.company.lesson6.classwork;

public class ConnectionConfigV1 {

    private static volatile ConnectionConfigV1 instance;
    private String host;
    private String password;

    private ConnectionConfigV1() {

    }
    public static ConnectionConfigV1 getInstance() {
        if (instance == null) {
            synchronized (ConnectionConfigV1.class) {
                if(instance == null) {
                    instance = new ConnectionConfigV1();
                }
            }
        }
        return instance;
    }
}

