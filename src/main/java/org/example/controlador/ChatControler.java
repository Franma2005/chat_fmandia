package org.example.controlador;

import org.example.entities.Config;
import org.example.modelo.ChatModel;
import org.example.modelo.ReciveMessage;
import org.example.vista.ChatView;

public class ChatControler {
    private ChatModel model;
    ReciveMessage  reciveMessage;
    private ChatView view;

    private static ChatControler instance;

    private ChatControler() {}

    public static ChatControler getInstance() {
        if (instance == null)
            instance = new ChatControler();
        return instance;
    }

    public void init() {
        this.model = ChatModel.getInstance();
        this.view = ChatView.getInstance(this);
        model.connect();
    }

    public void sendMessage() {
        model.sendMessage(view.getTextSend());
    }
}
