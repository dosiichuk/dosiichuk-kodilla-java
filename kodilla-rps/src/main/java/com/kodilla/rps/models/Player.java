package com.kodilla.rps.models;

public final class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score++;
    }

    public void resetScore() {
        score = 0;
    }

    public void setName(String name) {
        this.name = name;
    }
}
