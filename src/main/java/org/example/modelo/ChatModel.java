package org.example.modelo;

import org.example.entities.Config;

//* Clase principal de modelo encargada de centralizar varias operaciones
public class ChatModel {

    // Clases encargadas del envio de mensajes y la recepcion
    private SendMessage sendMessage;
    private ReciveMessage reciveMessage;

    // Usamos la clase config para recuperar la informacion del servidor
    private static final Config config = Config.getInstance();
    private static ChatModel instance;

    // Constructor
    private ChatModel(String ip, int port) {
        this.sendMessage = new SendMessage(ip, port);
        this.reciveMessage = new ReciveMessage(ip, port);
    }

    // Patrón de instancia unica
    public static ChatModel getInstance() {
        if(instance == null)
            instance = new ChatModel(config.getIP(), config.getPORT());
        return instance;
    }

    // Se abren los canales de envio y recepción de mensajes
    public void connect() {
        sendMessage.startBytesChannels();
        sendMessage.startTextChannels();
        reciveMessage.startBytesChannels();
        reciveMessage.startTextChannels();
        new Thread(reciveMessage).start();
    }

    // Se cierran los canales de envio y recepción de mensajes
    public void disconnect() {
        sendMessage.stopBytesChannels();
        sendMessage.stopTextChannels();
        reciveMessage.stopBytesChannels();
        reciveMessage.stopTextChannels();
    }

    //
    public void sendMessage(String message) {
        sendMessage.sendMessage(message);
        System.out.println(message);
    }
}
