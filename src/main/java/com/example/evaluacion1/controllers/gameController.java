package com.example.evaluacion1.controllers;

import com.example.evaluacion1.services.VideogameService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/game")
public class gameController {

    private final VideogameService videogameService;

    public gameController(VideogameService videogameService) {
        this.videogameService = videogameService;
    }

    @GetMapping
    public String getGame(@RequestParam String name
    ) throws IOException {
        return videogameService.getVideogameByName(name);
    }
}
