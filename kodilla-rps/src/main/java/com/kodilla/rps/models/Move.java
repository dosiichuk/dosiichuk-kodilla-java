package com.kodilla.rps.models;

public enum Move {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    private final int moveNumber;

    Move(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public static Move getMove(int moveNumber) {
        switch (moveNumber) {
            case 1:
                return ROCK;
            case 2:
                return PAPER;
            case 3:
                return SCISSORS;
            default:
                return null;
        }
    }

    public static Move getMoveThatBeats(Move move) {
        switch (move) {
            case ROCK:
                return PAPER;
            case PAPER:
                return SCISSORS;
            case SCISSORS:
                return ROCK;
            default:
                return null;
        }
    }

    public static Move getMoveThatLosesTo(Move move) {
        switch (move) {
            case ROCK:
                return SCISSORS;
            case PAPER:
                return ROCK;
            case SCISSORS:
                return PAPER;
            default:
                return null;
        }
    }
}
