/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.example.interfaces;

import org.example.entities.Message;
import org.example.vista.ChatView;


/**
 *
 * @author fmandia
 */
//* Utilizamos el patrón command para controlar las diferentes acciones a realizar
public interface MyCommand {
    
    public void execute(Message message, ChatView chatview);
    
}
