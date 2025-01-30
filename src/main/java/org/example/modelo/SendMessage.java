package org.example.modelo;

import org.example.entities.Message;

//* Clase para el envio de mensajes
public class SendMessage {

    private SocketTCPClient socket;

    public SendMessage(SocketTCPClient socket) {
        this.socket = socket;
    }

    public void sendMessage(Message message) {
        socket.getPw().println(message);
        socket.getPw().flush();
    }
}
