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
        startSocket(ipServer, port);
    }

    private void startSocket(String ipServer, int port) {
        try {
            socket = new Socket(ipServer, port);
        } catch (IOException exception) {
            System.out.println("Error al inicializar el socket del cliente");
        }

    }

    public void startBytesChannels() {
        try {
            out = socket.getOutputStream();
            in = socket.getInputStream();
        } catch (IOException exception) {
            System.out.println("Exception open the bytes channels of the socket");
        }
    }

    public void startTextChannels() {
        br = new BufferedReader(new InputStreamReader(in));
        pw = new PrintWriter(out, true);
    }

    public void stopBytesChannels() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException exception) {
            System.out.println("Exception close the bytes channels of the socket");
        }
    }

    public void stopTextChannels() {
        try {
            br.close();
            pw.close();
        } catch (IOException exception) {
            System.out.println("Exception close the text channels of the socket");
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public BufferedReader getBr() {
        return br;
    }

    public PrintWriter getPw() {
        return pw;
    }
}
