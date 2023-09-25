package com.example.evaluacion1.controllers;

import com.example.evaluacion1.services.ConsoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/consoles")
public class ConsolesController {

    private final ConsoleService consoleService;

    public ConsolesController(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @GetMapping("/{console_abreviation}/random_games")
    public ResponseEntity<List<String>> getRecomendByConsole(@PathVariable String console_abreviation
    ) throws IOException {
       List<String> videogamesFormated = consoleService.formatVideogamesToString(console_abreviation);

        return ResponseEntity.ok(videogamesFormated);
    }
}
