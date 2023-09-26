package com.example.evaluacion1.services;

import com.example.evaluacion1.models.Videogame;
import com.example.evaluacion1.utils.GetRandomVideogame;
import com.example.evaluacion1.utils.JSON_Handler;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VideogameService {

    private final JSON_Handler jsonHandler = new JSON_Handler();
    private List<Videogame> videogamesArr = jsonHandler.convertAllVideogames();
    private final GetRandomVideogame getRandomVideogame = new GetRandomVideogame();

    public VideogameService() throws IOException {
    }
    /**
     * This method returns a list of videogames by genre
     * @param genreName The name of the genre
     * @return A list of videogames by genre
     **/
    public List<Videogame> getVideogamesByGenre(String genreName) {
        List<Videogame> videogames = new ArrayList<>();

        for (Videogame videogame : videogamesArr) {
            for (int i = 0; i < videogame.getGenres().length; i++) {
                if (videogame.getGenres()[i].equals(genreName)) {
                    videogames.add(videogame);
                }
            }
        }
        return videogames;
    }

    /**
     * This method returns a list of strings with the information of the videogames
     *
     * @param videogames The list of videogames
     * @return A list of strings with the information of the videogames
     */
    public List<String> formatToString(List<Videogame> videogames) {
        return videogames.stream().
                map(Videogame::toString)
                .collect(Collectors.toList());
    }


    /**
     * This method returns a list of strings with the information of the videogames
     *
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

    /**
     * This method returns a recomendation list of numGames games by genre
     * @param genreName The name of the genre
     * @param numGames The number of games to recomend
     * @return a list of strings with the information of the videogames
     * **/
    public List<String> convertGamesByGenre(String genreName, int numGames) throws IOException {
        //Este array viene vacio
        List<Videogame> videogamesByGenre = getVideogamesByGenre(genreName);

        //Aqui da problemas pq el arr viene vacio
        List<Videogame> randomVideogames = getRandomVideogame.getRandomVideogame(videogamesByGenre, numGames);

        return formatToString(randomVideogames);
    }


    /**
     * This method returns a recommendation list of 3 videogames by genre
     * @param genreName The name of the genre
     * @return A recommendation list of 3 videogames
     * **/
    public List<String> getRecomendedVideogame(String genreName, String consoleAbbreviation) throws Exception {
        List<Videogame> videogames = jsonHandler.convertAllVideogames();

        videogames = videogames.stream()
                .filter(videogame -> Arrays.asList(videogame.getGenres()).contains(genreName))
                .filter(videogame -> videogame.getVideo_console().equalsIgnoreCase(consoleAbbreviation))
                .collect(Collectors.toCollection(ArrayList::new));

        return  formatToString(getRandomVideogame.getRandomVideogame(videogames, 1));
    }

        /**
        This method returns a videogame by its name
        @param name The name of the videogame
        @return A String with the information of the videogame formated
        @throws IOException If the file is not found
     */
        public String  getVideogameByName(String name) throws IOException {
            Optional<Videogame> videogame;

            videogame = videogamesArr.stream().filter(videogameSearched -> videogameSearched.getName().equalsIgnoreCase(name))
                    .findFirst();
            if (videogame.isEmpty()){
                return "Juego no encontrado en nuestra base de datos";
            }

            return videogame.get().toStringWithoutName();
        }

    }








