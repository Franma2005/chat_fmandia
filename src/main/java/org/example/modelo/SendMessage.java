package org.example.modelo;

public class SendMessage extends SocketTCPClient {


    public SendMessage(String ipServer, int port) {
        super(ipServer, port);
    }

    public void sendMessage(String message) {
        System.out.println("(Client) " + message);
        getPw().println(message);
        getPw().flush();
    }
}
