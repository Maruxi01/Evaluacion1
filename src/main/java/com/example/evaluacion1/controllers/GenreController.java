package com.example.evaluacion1.controllers;

import com.example.evaluacion1.models.Videogame;
import com.example.evaluacion1.services.VideogameService;
import com.example.evaluacion1.utils.GetRandomVideogame;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {
    private VideogameService videogameService;

    public GenreController(VideogameService videogameService)  {
        this.videogameService = videogameService;
    }

    @GetMapping("/{genreName}")
    public ResponseEntity<List<Videogame>> getVideoGamesByGenre(@PathVariable String genreName) {

        List<Videogame> videogamesByGenre =  videogameService.getVideogamesByGenre(genreName);
        return ResponseEntity.ok(videogamesByGenre);
    }
    @PostMapping("/random_games/{genreName}")
    public ResponseEntity<List<String>> recomend3GamesByGenre(@PathVariable String genreName){

        GetRandomVideogame getRandomVideogame = new GetRandomVideogame();

        List<String> finalGames = new ArrayList<>();

        List<Videogame> videogamesByGenre =  videogameService.getVideogamesByGenre(genreName);

        List<Videogame> randomVideogames = getRandomVideogame.getRandomVideogame(videogamesByGenre, 3);

        for(Videogame video: randomVideogames){
            finalGames.add(video.toString());
        }

        return ResponseEntity.ok(finalGames);


    }
}
