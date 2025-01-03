package com.kodilla.rps.models;

public final class GameRound {
    private final Player humanPlayer;
    private final Player computerPlayer;
    private final Move humanPlayerMove;
    private final Move computerPlayerMove;
    private final RoundResult roundResult;

    public GameRound(Player humanPlayer, Player computerPlayer, Move humanPlayerMove, Move computerPlayerMove) {
        this.humanPlayer = humanPlayer;
        this.computerPlayer = computerPlayer;
        this.humanPlayerMove = humanPlayerMove;
        this.computerPlayerMove = computerPlayerMove;
        this.roundResult = calculateRoundResult();
    }

    public RoundResult calculateRoundResult() {
        if (humanPlayerMove == computerPlayerMove) {
            return RoundResult.DRAW;
        }
        if (humanPlayerMove == Move.ROCK && computerPlayerMove == Move.SCISSORS) {
            return RoundResult.HUMAN_PLAYER_WIN;
        } else if (humanPlayerMove == Move.PAPER && computerPlayerMove == Move.ROCK) {
            return RoundResult.HUMAN_PLAYER_WIN;
        } else if (humanPlayerMove == Move.SCISSORS && computerPlayerMove == Move.PAPER) {
            return RoundResult.HUMAN_PLAYER_WIN;
        } else {
            return RoundResult.COMPUTER_PLAYER_WIN;
        }
    }

    public RoundResult getRoundResult() {
        return roundResult;
    }

    public Move getHumanPlayerMove() {
        return humanPlayerMove;
    }

    public Move getComputerPlayerMove() {
        return computerPlayerMove;
    }
}
