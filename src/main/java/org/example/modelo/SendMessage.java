package org.example.modelo;

//* Clase para el envio de mensajes
public class SendMessage extends SocketTCPClient {

    public SendMessage(String ipServer, int port) {
        super(ipServer, port);
    }

    public void sendMessage(String message) {
        getPw().println(message);
        getPw().flush();
    }
}
