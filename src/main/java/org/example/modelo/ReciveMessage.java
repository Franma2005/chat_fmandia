package org.example.modelo;

import org.example.controlador.ChatControler;
import org.example.interfaces.MyObservable;

import java.io.IOException;

public class ReciveMessage extends SocketTCPClient implements  Runnable, MyObservable {

    private ChatControler controler;

    public ReciveMessage(String ipServer, int port) {
        super(ipServer, port);
        controler = ChatControler.getInstance();
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
        }
    }

    @Override
    public void emit() {

    }
}
