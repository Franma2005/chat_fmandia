package org.example.modelo;

//* Clase para el envio de mensajes
public class SendMessage {

    private SocketTCPClient socket;

    public SendMessage(SocketTCPClient socket) {
        this.socket = socket;
    }

    public void sendMessage(String message) {
        socket.getPw().println(message);
        socket.getPw().flush();
    }
}
