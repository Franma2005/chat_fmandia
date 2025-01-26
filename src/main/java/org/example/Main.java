package org.example;

import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import org.example.controlador.ChatControler;

public class Main {
    public static void main(String[] args) {

        FlatDarkPurpleIJTheme.setup();

        ChatControler chatControler = ChatControler.getInstance();
        chatControler.init();
    }
}