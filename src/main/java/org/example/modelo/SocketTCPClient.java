package org.example.modelo;

import java.io.*;
import java.net.Socket;

public class SocketTCPClient {

    private String ipServer;
    private int port;
    private Socket socket;
    private InputStream in;
    private OutputStream out;
    private BufferedReader br;
    private PrintWriter pw;

    public SocketTCPClient(String ipServer, int port) {
        this.ipServer = ipServer;
        this.port = port;
    }

    public void start() throws IOException {
        System.out.println("Opening the channels of communication");
        socket = new Socket(ipServer, port);
        out = socket.getOutputStream();
        in = socket.getInputStream();
        System.out.println("The channels of communication have been opened");
    }

    public void startTextChannels() {
        System.out.println("Opening the text channels of communication");
        br = new BufferedReader(new InputStreamReader(in));
        pw = new PrintWriter(out);
        System.out.println("The text channels of communication have been closed");
    }

    public void stop() {
        System.out.println("Closing the channels of communication");
    }
}
