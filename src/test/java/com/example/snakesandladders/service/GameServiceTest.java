package com.example.snakesandladders.service;

import com.example.snakesandladders.model.Player;
import com.example.snakesandladders.storage.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    @InjectMocks
    GameService gameService;

    @Mock
    BoardRepository boardRepository;

    @Mock
    DiceyService diceyService;

    @Test
    public void startNewGameTest() {
        String playerName = "player1";
        Player player = createPlayer(playerName, 1);

        Player result = gameService.startNewGame(playerName);

        verify(boardRepository, times(1)).savePlayer(player);

        assertNotNull(result);
        assertEquals(result.getName(), playerName);
        assertEquals(result.getToken(), 1);
        assertFalse(result.isWinner());
    }

    @Test
    public void moveTokenTest() {
        String playerName = "player1";
        Player player = createPlayer(playerName, 7);

        when(boardRepository.findPlayerByName(playerName)).thenReturn(player);
        when(diceyService.generateDiceValue()).thenReturn(5);

        Player result = gameService.moveToken(playerName);

        verify(boardRepository, times(1)).findPlayerByName(playerName);
        verify(boardRepository, times(1)).savePlayer(player);

        assertNotNull(result);
        assertEquals(result.getName(), playerName);
        assertEquals(result.getToken(), 12);
        assertFalse(result.isWinner());
    }

    @Test
    public void moveTokenWinnerTest() {
        String playerName = "player1";
        Player player = createPlayer(playerName, 99);

        when(boardRepository.findPlayerByName(playerName)).thenReturn(player);
        when(diceyService.generateDiceValue()).thenReturn(4);

        Player result = gameService.moveToken(playerName);

        verify(boardRepository, times(1)).findPlayerByName(playerName);
        verify(boardRepository, times(1)).savePlayer(player);

        assertNotNull(result);
        assertEquals(result.getName(), playerName);
        assertEquals(result.getToken(), 103);
        assertTrue(result.isWinner());
    }

    private Player createPlayer(String playerName, int token) {
        Player player = new Player();
        player.setName(playerName);
        player.setToken(token);
        player.setWinner(false);
        return player;
    }

}
