package com.example.evaluacion1.services;

import com.example.evaluacion1.models.Videogame;
import com.example.evaluacion1.utils.JSON_Handler;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ConsoleService {

public List<Videogame> getRecomendByConsole(String console_abreviation) throws IOException {
    ArrayList<Videogame> allVideogames;

    JSON_Handler json_handler = new JSON_Handler();
    return json_handler.getAllVideogames("data/"+console_abreviation+".json");
    }

    public List<String> formatVideogamesToString(String console_abreviation) throws IOException {
    List<Videogame> videogames=  getRecomendByConsole(console_abreviation);
    List<String> videogamesString = new ArrayList<>();
    for(Videogame videogame: videogames){
        videogamesString.add( videogame.getName() +" - "+ videogame.getVideo_console() +" - "+ Arrays.toString(videogame.getGenres()));
    }

    return selectRandomGames(videogamesString);
    }

    public List<String> selectRandomGames(List<String> videogames){
        List<String> randomGames = new ArrayList<>();
        for(int i=0; i<2; i++){
            int randomIndex = (int) (Math.random() * videogames.size());
            randomGames.add(videogames.get(randomIndex));
        }
        return randomGames;
    }

}
