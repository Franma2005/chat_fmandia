package org.example.controlador;

import org.example.entities.Config;
import org.example.interfaces.MyObservable;
import org.example.interfaces.MyObserver;
import org.example.modelo.ChatModel;
import org.example.modelo.ReciveMessage;
import org.example.vista.ChatView;

import java.util.ArrayList;

public class ChatControler implements MyObserver {
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

    public void closeChannels() {

        model.disconnect();
    }

    @Override
    public void update(String message) {
        view.setTextArea(message + "\n");
    }
}
