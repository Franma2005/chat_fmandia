package org.example.controlador;

import java.util.HashMap;
import org.example.command.CreateChatRoom;
import org.example.command.ObtainMessage;
import org.example.entities.Message;
import org.example.entities.Action;
import org.example.interfaces.MyCommand;
import org.example.interfaces.MyObserver;
import org.example.modelo.ChatModel;
import org.example.services.JsonService;
import org.example.vista.ChatView;

//* Esta clase se usa para unir la vista y el controlador
public class ChatControler implements MyObserver {
    // Vistas y controladores
    private ChatModel model;
    private ChatView view;
    private HashMap<Action, MyCommand> commands;
    private JsonService jsonService;

    // Instancia unica
    private static ChatControler instance;

    private ChatControler() {
        commands = new HashMap<>() {{
            put(Action.SEND_MESSAGE, new ObtainMessage());
            put(Action.CREATE_CHAT_ROOM, new CreateChatRoom());
        }};
        jsonService = JsonService.getInstance();
    }

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
    public void sendMessage(Action action, String message) {
        Message jsonMessage = new Message(action, message);
        model.sendMessage(jsonMessage);
    }

    // Cerrar los canales de comunicacion del cliente
    public void closeChannels() {
        model.disconnect();
    }

    // Metodo del patron observer que es notificado cuando llega un mensaje
    @Override
    public void update(String messageJson) {
        Message message = jsonService.destructureJson(messageJson);
        commands.get(message.getAction()).execute(message, view);
    }
}
