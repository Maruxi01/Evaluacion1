package com.example.evaluacion1.services;

import com.example.evaluacion1.models.Videogame;
import com.example.evaluacion1.utils.JSON_Handler;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class VideogameService {
    private final ArrayList<Videogame> VIDEOGAMES_ARR = convertVideogames();

    public VideogameService() throws IOException {
    }


    public ArrayList<Videogame> convertVideogames() throws IOException {
        ArrayList<Videogame> videogames;

        JSON_Handler json_handler = new JSON_Handler();
        videogames = json_handler.getAllVideogames("data/GBA.json");
        videogames.addAll(json_handler.getAllVideogames("data/PS2.json"));
        videogames.addAll(json_handler.getAllVideogames("data/N64.json"));

     return videogames;
    }

    public ArrayList<Videogame> getVideogamesByGenre(String genre_name){
        ArrayList<Videogame> videogames = new ArrayList<>();

        for (Videogame videogame : VIDEOGAMES_ARR){
            for (int i = 0; i < videogame.getGenres().length; i++){
                if (videogame.getGenres()[i].equals(genre_name)){
                    videogames.add(videogame);
                }
            }
        }
        return videogames;
    }

    }






