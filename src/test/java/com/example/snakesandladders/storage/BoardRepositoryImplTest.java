package com.example.snakesandladders.storage;

import com.example.snakesandladders.model.Player;
import com.example.snakesandladders.storage.impl.BoardRepositoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BoardRepositoryImplTest {

    @Spy
    BoardRepositoryImpl boardRepository;

    @Test
    public void findPlayerByNameTest() {
        Player result = boardRepository.findPlayerByName("player1");
        assertNull(result);
    }

    @Test
    public void savePlayerTest() {
        Player player = new Player();
        String playerName = "player1";
        player.setName(playerName);
        player.setToken(10);
        player.setWinner(false);

        boardRepository.savePlayer(player);
        Player result = boardRepository.findPlayerByName("player1");

        assertNotNull(result);
        assertEquals(playerName, result.getName());
        assertEquals(10, result.getToken());
        assertFalse(result.isWinner());
    }
}
