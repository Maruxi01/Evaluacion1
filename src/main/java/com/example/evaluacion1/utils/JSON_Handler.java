package com.example.evaluacion1.utils;

import com.example.evaluacion1.models.Videogame;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JSON_Handler {
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public ArrayList<Videogame> getAllVideogames(String path) throws IOException {
        ArrayList<Videogame> allVideogames;

        allVideogames = JSON_MAPPER.readValue(new File(path),
        JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Videogame.class));


        return allVideogames;
    }
}
