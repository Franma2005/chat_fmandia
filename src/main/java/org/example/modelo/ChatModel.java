package org.example.modelo;

import java.io.IOException;

public class ChatModel {

    private SocketTCPClient socketClient;

    public ChatModel(String ip, int port) {
        this.socketClient = new SocketTCPClient(ip, port);
    }

    public void connect() {
        socketClient.start();
        socketClient.startTextChannels();
    }

    public void disconnect() {
        socketClient.stop();
        socketClient.stopTextChannels();
    }
}
