package com.example.evaluacion1.utils;

import com.example.evaluacion1.models.Videogame;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSON_Handler {
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public List<Videogame> getAllVideogames(String path) throws IOException {
        ArrayList<Videogame> allVideogames;
        allVideogames = JSON_MAPPER.readValue(new File(path),
        JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Videogame.class));

        return allVideogames;
    }

    public List<Videogame> converAlltVideogames() throws IOException {
        List<Videogame> videogames = getAllVideogames("data/GBA.json");
        videogames.addAll(getAllVideogames("data/PS2.json"));
        videogames.addAll(getAllVideogames("data/N64.json"));

        return videogames;
    }

    public List<Videogame> converGamesByConsole(String consoleAbreviation) throws IOException {
        return getAllVideogames("data/"+consoleAbreviation+".json");
    }
}
