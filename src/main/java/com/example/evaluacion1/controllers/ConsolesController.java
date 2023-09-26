package com.example.evaluacion1.controllers;

import com.example.evaluacion1.services.VideogameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/consoles")
public class ConsolesController {

    private final VideogameService videogameService;

    public ConsolesController(VideogameService videogameService) {
        this.videogameService = videogameService;
    }

    /**
     * This method returns a list of videogames by console
     * @param consoleAbreviation The abbreviation of the console
     * @return A list of videogames by console
     * @throws IOException If the file is not found
     */
    @GetMapping("/{consoleAbreviation}/randomGames")
    public ResponseEntity<List<String>> getRecomendByConsole(@PathVariable String consoleAbreviation
    ) throws IOException {
       List<String> videogamesFormated = videogameService.converGamesByConsole(consoleAbreviation);

        return ResponseEntity.ok(videogamesFormated);
    }

    /**
     * This method returns a recommendation list of 3 videogames by genre
     * @param genreName The name of the genre
     * @return A recommendation list of 3 videogames
     * **/
    @PostMapping("/{consoleAbreviation}/genre/random_game")
    public ResponseEntity <List<String>> getRecomendedVideogame(@RequestBody String genreName, @PathVariable String consoleAbreviation)
            throws Exception {
        List<String> videogameFormated = videogameService.getRecomendedVideogame(genreName, consoleAbreviation);
        return ResponseEntity.ok(videogameFormated);
    }
}
