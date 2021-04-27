package com.example.snakesandladders.controller;

import com.example.snakesandladders.model.Player;
import com.example.snakesandladders.service.GameService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final GameService gameService;

    public MainController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/startGame")
    public Player startGame(@RequestParam String playerName) {
        return gameService.startNewGame(playerName);
    }

    @PostMapping("/rollDice/{playerName}")
    public Player rollDice(@PathVariable String playerName) {
        return gameService.moveToken(playerName);
    }
}
