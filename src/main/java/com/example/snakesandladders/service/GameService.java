package com.example.snakesandladders.service;

import com.example.snakesandladders.model.Player;
import com.example.snakesandladders.storage.BoardRepository;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private DiceService diceService;

    private BoardRepository boardRepository;

    private static final int LAST_SQUARE = 100;

    public GameService(DiceService diceService, BoardRepository boardRepository) {
        this.diceService = diceService;
        this.boardRepository = boardRepository;
    }

    public Player moveToken(String playerName) {
        Player player = boardRepository.findPlayerByName(playerName);
        int newToken = player.getToken() + diceService.generateDiceValue();
        if (winnerCheck(newToken)) {
            player.setWinner(true);
        }
        player.setToken(newToken);
        boardRepository.savePlayer(player);
        return player;
    }

    public Player startNewGame(String playerName) {
        Player player = new Player();
        player.setName(playerName);
        player.setToken(1);
        player.setWinner(false);
        boardRepository.savePlayer(player);
        return player;
    }

    private boolean winnerCheck(int token) {
        return token >= LAST_SQUARE;
    }
}
