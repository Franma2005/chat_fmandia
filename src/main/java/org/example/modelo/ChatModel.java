package org.example.modelo;

import java.io.IOException;

public class ChatModel {

    private SendMessage sendMessage;
    private ReciveMessage reciveMessage;

    public ChatModel(String ip, int port) {
        this.sendMessage = new SendMessage(ip, port);
        this.reciveMessage = new ReciveMessage(ip, port);
    }

    public void connect() {
        sendMessage.startBytesChannels();
        sendMessage.startTextChannels();
        reciveMessage.startBytesChannels();
        reciveMessage.startTextChannels();
    }

    public void disconnect() {
        sendMessage.stopBytesChannels();
        sendMessage.stopTextChannels();
        reciveMessage.startBytesChannels();
        reciveMessage.stopTextChannels();
    }

    public void sendMessage(String message) {
        sendMessage.sendMessage(message);
    }
    
    public String reciveMessage() {
        return socketClient.reciveMessage();
    }
}
