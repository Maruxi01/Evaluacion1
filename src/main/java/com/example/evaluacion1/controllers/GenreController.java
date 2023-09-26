package com.example.evaluacion1.controllers;

import com.example.evaluacion1.services.VideogameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {
    private VideogameService videogameService;

    public GenreController(VideogameService videogameService)  {
        this.videogameService = videogameService;
    }
    /**
     * This method returns a recommendation list of 3 videogames by genre
     * @param genreName The name of the genre
     * @return A recommendation list of 3 videogames
     * **/
    @PostMapping("/random_games")
    public ResponseEntity<List<String>> recommend3GamesByGenre(@RequestBody String genreName) throws IOException {
        List<String> finalGames;
        finalGames = videogameService.convertGamesByGenre(genreName, 3);

        return ResponseEntity.ok(finalGames);

    }
}
