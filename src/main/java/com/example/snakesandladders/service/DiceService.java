package com.example.snakesandladders.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DiceService {

    public int generateDiceValue() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
