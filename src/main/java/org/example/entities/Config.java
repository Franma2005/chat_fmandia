package org.example.entities;

//* Clase de configuración donde se incluyen las especificaciones del servidor al que nos vamos a conectar
public class Config {

    //Ip y puerto
    private final String IP = "127.0.0.1";
    private final int PORT = 3000;

    // Instancia unica
    private static Config instance;

    // Metodo instancia unica
    public Config() {
    }

    // Getters
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
