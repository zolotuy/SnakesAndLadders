package com.example.snakesandladders.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class DiceServiceTest {

    @InjectMocks
    DiceService diceService;

    @Test
    public void generateDiceValueTest() {
        int result = diceService.generateDiceValue();
        assertTrue(result >= 1 && result <= 6);
    }
}
