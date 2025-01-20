package org.example.modelo;

import java.io.IOException;

public class ChatModel {

    private SocketTCPClient socketClient;

    public ChatModel(String ip, int port) {
        this.socketClient = new SocketTCPClient(ip, port);
    }

    public void connect() {
        try {
            socketClient.start();
            socketClient.startTextChannels();
        } catch (IOException exception) {
            System.out.println("Error trying to connect the client: " + exception.getMessage());
        }

    }

    public void disconnect() {
        try {
            socketClient.stop();
            socketClient.stopTextChannels();
        } catch (IOException exception) {
            System.out.println("Error trying to disconnect the client: " + exception.getMessage());
        }
    }

    public void sendMessage(String message) {
        socketClient.sendMessage(message);
    }
    
    public String reciveMessage() {
        try {
            String message = socketClient.reciveMessage();
            return message;
        } catch (IOException exception) {
            System.out.println("Error trying to recive the message: " + exception.getMessage());
        }
        return "";
    }
}
