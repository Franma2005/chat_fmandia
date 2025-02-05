/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.command;

import org.example.entities.Message;
import org.example.interfaces.MyCommand;
import org.example.vista.ChatView;

/**
 *
 * @author fmandia
 */
//* Patrón command para recivir mensajes
public class ObtainMessage implements MyCommand{

    public ObtainMessage() {}

    @Override
    public void execute(Message message, ChatView chatview) {
        chatview.setTextArea(message.getContent() + " :" + message.getTime() + "\n");
    }
}
