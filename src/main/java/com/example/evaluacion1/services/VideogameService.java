package com.example.evaluacion1.services;

import com.example.evaluacion1.models.Videogame;
import com.example.evaluacion1.utils.GetRandomVideogame;
import com.example.evaluacion1.utils.JSON_Handler;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideogameService {

    private List<Videogame> videogamesArr ;

    private final JSON_Handler jsonHandler = new JSON_Handler();

    private final GetRandomVideogame getRandomVideogame = new GetRandomVideogame();

    public VideogameService() throws IOException {
        this.videogamesArr = jsonHandler.converAlltVideogames();
    }

    public List<Videogame> getVideogamesByGenre(String genreName){
        List<Videogame> videogames = new ArrayList<>();

        for (Videogame videogame : videogamesArr){
            for (int i = 0; i < videogame.getGenres().length; i++){
                if (videogame.getGenres()[i].equals(genreName)){
                    videogames.add(videogame);
                }
            }
        }
        return videogames;
    }

    /**
     * This method returns a list of strings with the information of the videogames
     * @param videogames The list of videogames
     * @return A list of strings with the information of the videogames
     */
    public List<String> formatToString(List<Videogame> videogames){
        return videogames.stream().
                map(Videogame::toString)
                .collect(Collectors.toList());
    }




    /**
     * This method returns a list of strings with the information of the videogames
     * @param consoleAbreviation The abbreviation of the console
     * @return A list of strings with the information of the videogames
     * @throws IOException If the file is not found
     */
    public List<String> converGamesByConsole(String consoleAbreviation) throws IOException {
        int numberOfGames = 2;
        List<Videogame> videogames = jsonHandler.converGamesByConsole(consoleAbreviation);
        videogames = getRandomVideogame.getRandomVideogame(videogames, numberOfGames);
        return formatToString(videogames);
    }

    }






