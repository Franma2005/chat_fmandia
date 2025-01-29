package org.example.modelo;

import org.example.controlador.ChatControler;
import org.example.interfaces.MyObservable;

import java.io.IOException;

//* Clase para la recepcion de mensajes
public class ReciveMessage extends SocketTCPClient implements  Runnable, MyObservable {

    // Necesitamos el controlador para, mediante el patron observer, notificar al controlador de la llegada de un mensaje
    private ChatControler controler;

    public ReciveMessage(String ipServer, int port) {
        super(ipServer, port);
        controler = ChatControler.getInstance();
    }

    public String reciveMessage() {
        String message = "";
        try {
            message = getBr().readLine();
        } catch (IOException exception) {
            System.out.println("Exception in the reception of one message");
        }
        return message;
    }

    // Se intentan recibir mensajes hasta que el socket se cierra.
    @Override
    public void run() {
        while(!this.getSocket().isClosed()) {
            emit();
        }
    }

    // Patrón observer
    @Override
    public void emit() {
        controler.update(reciveMessage());
    }
}
