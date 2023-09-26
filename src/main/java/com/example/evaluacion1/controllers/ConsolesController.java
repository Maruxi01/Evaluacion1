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

    @GetMapping("/{consoleAbreviation}/randomGames")
    public ResponseEntity<List<String>> getRecomendByConsole(@PathVariable String consoleAbreviation
    ) throws IOException {
       List<String> videogamesFormated = consoleService.formatVideogamesToString(consoleAbreviation);

        return ResponseEntity.ok(videogamesFormated);
    }
}
