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

    @GetMapping("/{consoleAbreviation}/randomGames")
    public ResponseEntity<List<String>> getRecomendByConsole(@PathVariable String consoleAbreviation
    ) throws IOException {
       List<String> videogamesFormated = videogameService.converGamesByConsole(consoleAbreviation);

        return ResponseEntity.ok(videogamesFormated);
    }
}
