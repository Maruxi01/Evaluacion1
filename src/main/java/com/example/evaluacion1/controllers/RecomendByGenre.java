package com.example.evaluacion1.controllers;

import com.example.evaluacion1.models.Videogame;
import com.example.evaluacion1.utils.JSON_Handler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
@RequestMapping("/recomendByGenre")
public class RecomendByGenre {


    @GetMapping("")
    public ResponseEntity<ArrayList<Videogame>> getRecomendByGenre() throws IOException {
        ArrayList<Videogame> allVideogames;

        JSON_Handler json_handler = new JSON_Handler();
        allVideogames= json_handler.getAllVideogames("data/GBA.json");

        return ResponseEntity.ok(allVideogames);
    }
}
