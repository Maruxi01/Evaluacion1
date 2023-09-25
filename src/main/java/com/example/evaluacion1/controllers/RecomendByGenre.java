package com.example.evaluacion1.controllers;

import com.example.evaluacion1.models.Videogame;
import com.example.evaluacion1.service.VideogameService;
import com.example.evaluacion1.utils.JSON_Handler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/genres")
public class RecomendByGenre {
    private VideogameService videogameService;

    public RecomendByGenre(VideogameService videogameService) throws IOException {
        this.videogameService = videogameService;
    }
    private final ArrayList<Videogame> VIDEOGAMES_ARR = videogameService.convertVideogames();

    @GetMapping("")
    public ResponseEntity<ArrayList<Videogame>> getRecomendByGenre() throws IOException {
        ArrayList<Videogame> allVideogames;

        JSON_Handler json_handler = new JSON_Handler();
        allVideogames= json_handler.getAllVideogames("data/GBA.json");

        return ResponseEntity.ok(allVideogames);
    }
    @PostMapping("/random_games/{genre_name}")
    public ResponseEntity<ArrayList<String>> recomend3GamesByGenre(@PathVariable String genre_name){
        ArrayList<String> randomGames = new ArrayList<>();

        for (Videogame videogame : VIDEOGAMES_ARR){
//            if (videogame.getGenres()[i] = genre_name){
//
//            }
//        }

        return ResponseEntity.ok(randomGames);


    }
}
