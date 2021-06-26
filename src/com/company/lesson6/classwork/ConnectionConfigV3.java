package com.company.lesson6.classwork;

public enum ConnectionConfigV3 {

    INSTANCE;
    private String host;
    private String password;

    public static ConnectionConfigV3 getInstance() {
        return INSTANCE;
    }

}

