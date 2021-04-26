package com.example.snakesandladders.storage;

import com.example.snakesandladders.model.Player;

public interface BoardRepository {

    Player findPlayerByName(String playerName);

    void savePlayer(Player player);
}
