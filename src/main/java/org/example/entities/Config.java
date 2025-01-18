package org.example.entities;

public class Config {

    private final String IP = "127.0.0.1";
    private final int PORT = 3000;

    private static Config instance;

    public Config() {
    }

    public static Config getInstance() {
        if (instance == null)
            instance = new Config();
        return instance;
    }

    public String getIP() {
        return IP;
    }

    public int getPORT() {
        return PORT;
    }
}
