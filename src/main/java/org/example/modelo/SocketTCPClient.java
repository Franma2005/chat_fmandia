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

    public void startBytesChannels() {
        try {
            System.out.println("(Client) Opening the channels of communication");
            socket = new Socket(ipServer, port);
            out = socket.getOutputStream();
            in = socket.getInputStream();
            System.out.println("(Client) The channels of communication have been opened");
        } catch (IOException exception) {
            System.out.println("Exception open the bytes channels of the socket");
        }
    }

    public void startTextChannels() {
        System.out.println("(Client) Opening the text channels of communication");
        br = new BufferedReader(new InputStreamReader(in));
        pw = new PrintWriter(out, true);
        System.out.println("(Client) The text channels of communication have been openned");
    }

    public void stopBytesChannels() {
        try {
            System.out.println("(Client) Closing the channels of communication");
            in.close();
            out.close();
            socket.close();
            System.out.println("(Client) The channels of communication have been opened");
        } catch (IOException exception) {
            System.out.println("Exception close the bytes channels of the socket");
        }
    }

    public void stopTextChannels() {
        try {
            System.out.println("(Client) Closing the text channels of communicantion");
            br.close();
            pw.close();
            System.out.println("(Client) The text channels of communication have been closed");
        } catch (IOException exception) {
            System.out.println("Exception close the text channels of the socket");
        }
    }

    public BufferedReader getBr() {
        return br;
    }

    public PrintWriter getPw() {
        return pw;
    }

    public void closeServerChannels() {

    }
}
