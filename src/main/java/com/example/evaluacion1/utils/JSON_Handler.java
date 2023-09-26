package com.example.evaluacion1.utils;

import com.example.evaluacion1.models.Videogame;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSON_Handler {
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    /**
     * This method converts elements of a json file into a list of videogames objects
     * @param path The path of the json file
     * @return A list of videogames objects
     * **/
    public List<Videogame> getAllVideogames(String path) throws IOException {
        ArrayList<Videogame> allVideogames;
        allVideogames = JSON_MAPPER.readValue(new File(path),
        JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Videogame.class));

        return allVideogames;
    }
    /**
     * This method convert all the videogames from the json files into a single list
     * @return A list of videogames objects
     * **/
    public List<Videogame> convertAllVideogames() throws IOException {
        List<Videogame> videogames = getAllVideogames("data/GBA.json");
        videogames.addAll(getAllVideogames("data/PS2.json"));
        videogames.addAll(getAllVideogames("data/N64.json"));

        return videogames;
    }

    /**
     * This method convert all the videogames from the json files into a single list
     * @param consoleAbreviation The abbreviation of the console
     * @return A list of videogames objects
     * **/
    public List<Videogame> converGamesByConsole(String consoleAbreviation) throws IOException {
        return getAllVideogames("data/"+consoleAbreviation+".json");
    }
}
