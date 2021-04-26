package com.example.snakesandladders.controller;

import com.example.snakesandladders.model.Player;
import com.example.snakesandladders.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private GameService gameService;

    @GetMapping("/startGame")
    public Player startGame(@RequestParam String playerName) {
        return gameService.startNewGame(playerName);
    }

    @GetMapping("/rollDice/{playerName}")
    public Player rollDice(@PathVariable String playerName) {
        return gameService.moveToken(playerName);
    }
}
