package com.example.evaluacion1.services;

import com.example.evaluacion1.models.Videogame;
import com.example.evaluacion1.utils.JSON_Handler;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class VideogameService {
    private final ArrayList<Videogame> VIDEOGAMES_ARR = convertVideogames();




    public ArrayList<Videogame> getVideogamesByGenre(String genre_name){
        ArrayList<Videogame> videogames = new ArrayList<>();

        for (Videogame videogame : VIDEOGAMES_ARR){
            for (int i = 0; i < videogame.getGenres().length; i++){
                if (videogame.getGenres()[i] == genre_name){
                    videogames.add(videogame);
                }
            }
        }
        return videogames;
    }

    }






