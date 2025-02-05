package org.example.modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.entities.Config;
import org.example.entities.Message;

//* Clase principal de modelo encargada de centralizar varias operaciones
public class ChatModel {

    // Clases encargadas del envio de mensajes y la recepcion
    private SocketTCPClient socketTCPClient;
    private SendMessage sendMessage;
    private ReciveMessage reciveMessage;

    // Usamos la clase config para recuperar la informacion del servidor
    private static final Config config = Config.getInstance();
    private static ChatModel instance;

    // Constructor
    private ChatModel(String ip, int port) {
        this.socketTCPClient = new SocketTCPClient(ip, port);
        this.sendMessage = new SendMessage(socketTCPClient);
        this.reciveMessage = new ReciveMessage(socketTCPClient);
    }

    // Patrón de instancia unica
    public static ChatModel getInstance() {
        if(instance == null)
            instance = new ChatModel(config.getIP(), config.getPORT());
        return instance;
    }

    // Se abren los canales de envio y recepción de mensajes
    public void connect() {
        socketTCPClient.startBytesChannels();
        socketTCPClient.startTextChannels();
        new Thread(reciveMessage).start();
    }

    // Se cierran los canales de envio y recepción de mensajes
    public void disconnect() {
        socketTCPClient.stopTextChannels();
        socketTCPClient.stopBytesChannels();
    }

    // Esta operación la he centralizado en esta clase
    public void sendMessage(Message message) {
        Gson gson = new GsonBuilder().create();
        sendMessage.sendMessage(gson.toJson(message));
    }
}
