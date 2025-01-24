package org.example.modelo;

import java.io.*;
import java.net.Socket;

public class SocketClient {
    private final String ipServer;
    private final int port;
    private Socket socket;
    OutputStream out;
    InputStream in;
    BufferedReader br;
    PrintWriter pw;

    public SocketClient(String ipServer, int port) {
        this.ipServer = ipServer;
        this.port = port;
    }

    public void start() throws IOException {
        System.out.println("(Client) Opening the channels of communication");
        socket = new Socket(ipServer, port);
        out = socket.getOutputStream();
        in = socket.getInputStream();
        System.out.println("(Client) The channels of communication have been opened");
    }

    public void startTextChannels() {
        System.out.println("(Client) Opening the text channels of communication");
        br = new BufferedReader(new InputStreamReader(in));
        pw = new PrintWriter(out, true);
        System.out.println("(Client) The text channels of communication have been openned");
    }

    public void stop() throws IOException {
        System.out.println("(Client) Closing the channels of communication");
        in.close();
        out.close();
        socket.close();
        System.out.println("(Client) The channels of communication have been opened");
    }

    public void stopTextChannels() throws IOException {
        System.out.println("(Client) Closing the text channels of communicantion");
        br.close();
        pw.close();
        System.out.println("(Client) The text channels of communication have been closed");
    }
}
