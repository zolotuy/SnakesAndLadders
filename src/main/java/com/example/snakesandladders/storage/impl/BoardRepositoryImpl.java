package com.example.snakesandladders.storage.impl;

import com.example.snakesandladders.model.Player;
import com.example.snakesandladders.storage.BoardRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BoardRepositoryImpl implements BoardRepository {

    private Map<String, Player> playerMap = new HashMap<>();

    @Override
    public Player findPlayerByName(String playerName) {
        return playerMap.get(playerName);
    }

    @Override
    public void savePlayer(Player player) {
        playerMap.put(player.getName(), player);
    }
}
