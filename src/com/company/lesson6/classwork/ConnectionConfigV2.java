package com.company.lesson6.classwork;

public class ConnectionConfigV2 {

    private String host;
    private String password;

    private ConnectionConfigV2() {

    }

    public static ConnectionConfigV2 getInstance() {
        return ConnectionConfigHolder.INSTANCE;
    }

    private static class ConnectionConfigHolder {
        private static final ConnectionConfigV2 INSTANCE = new ConnectionConfigV2();
    }
}

