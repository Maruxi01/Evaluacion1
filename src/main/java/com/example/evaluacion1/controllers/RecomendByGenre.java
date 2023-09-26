package com.example.evaluacion1.controllers;

import com.example.evaluacion1.models.Videogame;
import com.example.evaluacion1.services.VideogameService;
import com.example.evaluacion1.utils.GetRandomVideogame;
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

    @GetMapping("/{genreName}")
    public ResponseEntity<ArrayList<Videogame>> getVideoGamesByGenre(@PathVariable String genreName) {

        ArrayList<Videogame> videogamesByGenre =  videogameService.getVideogamesByGenre(genreName);
        return ResponseEntity.ok(videogamesByGenre);
    }
    @PostMapping("/random_games/{genreName}")
    public ResponseEntity<ArrayList<String>> recomend3GamesByGenre(@PathVariable String genreName){

        GetRandomVideogame getRandomVideogame = new GetRandomVideogame();

        ArrayList<String> finalGames = new ArrayList<>();

        ArrayList<Videogame> videogamesByGenre =  videogameService.getVideogamesByGenre(genreName);

        ArrayList<Videogame> randomVideogames = getRandomVideogame.getRandomVideogame(videogamesByGenre, 3);

        for(Videogame video: randomVideogames){
            finalGames.add(video.toString());
        }

        return ResponseEntity.ok(finalGames);


    }
}
