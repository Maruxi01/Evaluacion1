package com.example.evaluacion1.service;

import com.example.evaluacion1.models.Videogame;
import com.example.evaluacion1.utils.JSON_Handler;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class VideogameService {

    public ArrayList<Videogame> convertVideogames() throws IOException {
        ArrayList<Videogame> videogames = new ArrayList<>();

        JSON_Handler json_handler = new JSON_Handler();
        videogames = json_handler.getAllVideogames("data/GBA.json");
        videogames.retainAll(json_handler.getAllVideogames("data/PS2.json"));
        videogames.retainAll(json_handler.getAllVideogames("data/N64.json"));

     return videogames;
    }







}
