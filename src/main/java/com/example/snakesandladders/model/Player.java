package com.example.snakesandladders.model;

import lombok.Data;

@Data
public class Player {
    private String name;
    private int token;
    private boolean isWinner;
}
