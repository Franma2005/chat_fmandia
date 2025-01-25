package org.example.controlador;

import org.example.modelo.ChatModel;
import org.example.modelo.ReciveMessage;
import org.example.vista.ChatView;

public class ChatControler {
    private ChatModel model;
    ReciveMessage reciveMessage;
    private ChatView view;

    private static ChatControler instance;

    public ChatControler(ChatModel model, ChatView view) {
        this.model = model;
        this.view = view;
    }

    public static ChatControler getInstance(ChatModel model, ChatView view) {
        if (instance == null)
            instance = new ChatControler(model, view);
        return instance;
    }

    public void init() {
        model.connect();
    }

    public void sendMessage() {
        model.sendMessage(view.getTextSend());
    }
    
    public void reciveMessage() {
        System.out.println("Hola" + reciveMessage.getMessage());
        view.setTextArea(reciveMessage.getMessage());
    }
}
