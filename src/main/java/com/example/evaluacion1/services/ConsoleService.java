package com.example.evaluacion1.services;

import com.example.evaluacion1.models.Videogame;
import com.example.evaluacion1.utils.GetRandomVideogame;
import com.example.evaluacion1.utils.JSON_Handler;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsoleService {

    private final JSON_Handler jsonHandler = new JSON_Handler();
    private final GetRandomVideogame getRandomVideogame = new GetRandomVideogame();


    /**
     * This method returns a list of strings with the information of the videogames
     * @param consoleAbreviation The abbreviation of the console
     * @return A list of strings with the information of the videogames
     * @throws IOException If the file is not found
     */
    public List<String> formatVideogamesToString(String consoleAbreviation) throws IOException {
        int numberOfGames = 2;
        List<Videogame> videogames = jsonHandler.converGamesByConsole(consoleAbreviation);
        videogames = getRandomVideogame.getRandomVideogame(videogames, numberOfGames);
        return formatToString(videogames);
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


}
