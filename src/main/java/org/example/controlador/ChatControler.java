package org.example.controlador;

import org.example.entities.Message;
import org.example.entities.Action;
import org.example.interfaces.MyObserver;
import org.example.modelo.ChatModel;
import org.example.vista.ChatView;

//* Esta clase se usa para unir la vista y el controlador
public class ChatControler implements MyObserver {
    // Vistas y controladores
    private ChatModel model;
    private ChatView view;

    // Instancia unica
    private static ChatControler instance;

    private ChatControler() {}

    // Metodo instancia unica
    public static ChatControler getInstance() {
        if (instance == null)
            instance = new ChatControler();
        return instance;
    }

    // Metodo para iniciar para crear instancia unica (después de la primera vez llamarla)
    public void init() {
        this.model = ChatModel.getInstance();
        this.view = ChatView.getInstance(this);
        model.connect();
    }

    // Enviar un mensaje
    public void sendMessage() {
        Message jsonMessage = new Message(Action.SEND_MESSAGE, view.getTextSend());
        model.sendMessage(jsonMessage);
    }

    // Enviar un mensaje
    public void sendMessage(String message) {
        Message jsonMessage = new Message(Action.CLOSE_WINDOW, message);
        model.sendMessage(jsonMessage);
    }

    // Cerrar los canales de comunicacion del cliente
    public void closeChannels() {
        model.disconnect();
    }

    // Metodo del patron observer que es notificado cuando llega un mensaje
    @Override
    public void update(String message) {
        view.setTextArea(message + "\n");
    }
}
