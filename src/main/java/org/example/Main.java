package org.example;

import org.example.controlador.ChatControler;

public class Main {
    public static void main(String[] args) {
        ChatControler chatControler = ChatControler.getInstance();
        chatControler.init();
    }
}