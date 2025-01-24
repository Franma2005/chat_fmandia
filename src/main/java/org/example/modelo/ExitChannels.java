package org.example.modelo;

import java.io.IOException;

public class ExitChannels extends SocketClient implements Runnable{

    public ExitChannels(String ipServer, int port) {
        super(ipServer, port);
    }

    public void stopTextChannels() throws IOException {
        System.out.println("(Client) Closing the text channels of communicantion");
        br.close();
        pw.close();
        System.out.println("(Client) The text channels of communication have been closed");
    }

    @Override
    public void run() {

    }
}
