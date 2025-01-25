package org.example.modelo;

import java.io.IOException;

public class ReciveMessage extends SocketTCPClient implements  Runnable{

    public ReciveMessage(String ipServer, int port) {
        super(ipServer, port);
    }

    public String reciveMessage() {
        String message = "";
        try {
            message = "(Server) " + getBr().readLine();
        } catch (IOException exception) {
            System.out.println("Exception in the reception of one message");
        }
        return message;
    }

    @Override
    public void run() {
        while(true) {
            reciveMessage();
        }
    }
}
