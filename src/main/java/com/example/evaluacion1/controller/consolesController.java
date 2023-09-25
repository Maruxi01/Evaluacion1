package com.example.evaluacion1.controller;

import com.example.evaluacion1.models.Videogame;
import com.example.evaluacion1.utils.JSON_Handler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/consoles")
public class consolesController {

    @GetMapping("/{console_abreviation}/random_games")
    public ResponseEntity<ArrayList<Videogame>> getRecomendByConsole(@PathVariable String console_abreviation
    ) throws IOException {
        ArrayList<Videogame> allVideogames;

        JSON_Handler json_handler = new JSON_Handler();
        allVideogames= json_handler.getAllVideogames("data/"+console_abreviation+".json");

        return ResponseEntity.ok(allVideogames);
    }
}
