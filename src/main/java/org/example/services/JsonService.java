/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.entities.Message;

/**
 *
 * @author fmandia
 */
public class JsonService {
    private Gson gson;
    private static JsonService instance;

    private JsonService() {
        this.gson = new GsonBuilder().create();
    }
    
    public static JsonService getInstance() {
        if(instance == null)
            instance = new JsonService();
        return instance;
    }
    
    // Metodos para trabajar con el json
    public String buildJson(Message message) {
        return gson.toJson(message);
    }

    public Message destructureJson(String message) {
        return gson.fromJson(message, Message.class);
    }
}
