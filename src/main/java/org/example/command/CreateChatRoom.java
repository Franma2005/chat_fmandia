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
//* Patrón command para crear nuevas salas de chat
public class CreateChatRoom implements MyCommand{
    
    public CreateChatRoom() {
        
    }

    @Override
    public void execute(Message message, ChatView chatview) {
        chatview.addListRoom(message.getContent());
    }
}
