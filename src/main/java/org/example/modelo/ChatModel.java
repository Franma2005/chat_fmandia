package org.example.modelo;

import org.example.entities.Config;

import java.io.IOException;

public class ChatModel {

    private SendMessage sendMessage;
    private ReciveMessage reciveMessage;

    private static final Config config = Config.getInstance();
    private static ChatModel instance;

    private ChatModel(String ip, int port) {
        this.sendMessage = new SendMessage(ip, port);
        this.reciveMessage = new ReciveMessage(ip, port);
    }

    public static ChatModel getInstance() {
        if(instance == null)
            instance = new ChatModel(config.getIP(), config.getPORT());
        return instance;
    }

    public void connect() {
        sendMessage.startBytesChannels();
        sendMessage.startTextChannels();
        reciveMessage.startBytesChannels();
        reciveMessage.startTextChannels();
        new Thread(reciveMessage).start();
    }

    public void disconnect() {
        sendMessage.stopBytesChannels();
        sendMessage.stopTextChannels();
        reciveMessage.startBytesChannels();
        reciveMessage.stopTextChannels();
    }

    public void sendMessage(String message) {
        sendMessage.sendMessage(message);
        System.out.println(message);
    }
}
