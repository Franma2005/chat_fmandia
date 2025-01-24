package org.example.modelo;

public class EntryChannels extends SocketClient implements Runnable {

    public EntryChannels(String ipServer, int port) {
        super(ipServer, port);
    }

    public void sendMessage(String message) {
        System.out.println("(Client) " + message);
        pw.println(message);
        pw.flush();
    }

    @Override
    public void run() {

    }
}
