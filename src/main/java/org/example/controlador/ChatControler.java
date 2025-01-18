package org.example.controlador;

import org.example.entities.Config;
import org.example.modelo.ChatModel;
import org.example.vista.ChatView;

public class ChatControler {
    private final Config config = Config.getInstance();
    private ChatModel model;
    private ChatView view;

    private static ChatControler instance;

    public ChatControler() {
        this.model = new ChatModel(config.getIP(), config.getPORT());
        this.view = new ChatView();
    }

    public static ChatControler getInstance() {
        if (instance == null)
            instance = new ChatControler();
        return instance;
    }

    public void init() {
        boolean salir;
        do {
           model.connect();
           sendMessage();
           salir = reciveMessage();
        } while(salir);
        model.disconnect();
    }

    public void sendMessage() {
        model.sendMessage(view.getTextSend());
    }
    
    public boolean reciveMessage() {
        String text = model.reciveMessage();
        view.setTextArea(text);
        if (text.equals("END")) {
            return false;
        }
        return true;
    }
}
