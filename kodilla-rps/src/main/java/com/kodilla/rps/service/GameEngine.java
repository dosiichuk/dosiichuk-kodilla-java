package com.kodilla.rps.service;

import com.kodilla.rps.models.GameRound;
import com.kodilla.rps.models.Move;
import com.kodilla.rps.models.Player;
import com.kodilla.rps.models.RoundResult;

import java.util.ArrayList;
import java.util.List;

public final class GameEngine {

    private static final GameEngine gameEngine = new GameEngine();
    private Player humanPlayer;
    private Player computerPlayer;
    private Player winner;
    private List<GameRound> gameRounds = new ArrayList<>();
    private boolean isGameOver = false;
    private int ROUNDS_TO_WIN;
    private GameRound currentGameRound;
    private double probabilityOfComputerWinning = 0.5;

    private GameEngine() {
        instantiatePlayers();
    }

    public void instantiatePlayers() {
        humanPlayer = new Player("Human");
        computerPlayer = new Player("Computer");
    }

    public void processMoves(int humanPlayerMove) {
        Move humanPlayerMoveType = Move.getMove(humanPlayerMove);
        int computerPlayerMove = getComputerMove(humanPlayerMoveType);
        Move computerPlayerMoveType = Move.getMove(computerPlayerMove);
        GameRound gameRound = new GameRound(humanPlayer, computerPlayer, humanPlayerMoveType, computerPlayerMoveType);
        gameRounds.add(gameRound);
        currentGameRound = gameRound;
        RoundResult roundResult = gameRound.getRoundResult();
        if (roundResult == RoundResult.HUMAN_PLAYER_WIN) {
            humanPlayer.increaseScore();
        } else if (roundResult == RoundResult.COMPUTER_PLAYER_WIN) {
            computerPlayer.increaseScore();
        }
        checkIfGameOver();
    }

    public void checkIfGameOver() {
        if (humanPlayer.getScore() == ROUNDS_TO_WIN) {
            winner = humanPlayer;
            isGameOver = true;
        } else if (computerPlayer.getScore() == ROUNDS_TO_WIN) {
            winner = computerPlayer;
            isGameOver = true;
        }
    }

    public int getComputerMove(Move humanPlayerMove) {
        double random = Math.random();
        boolean computerShouldWin = random < probabilityOfComputerWinning;
        if (computerShouldWin) {
            return Move.getMoveThatBeats(humanPlayerMove).getMoveNumber();
        } else {
            return Move.getMoveThatLosesTo(humanPlayerMove).getMoveNumber();
        }
    }

    public void resetGame() {
        humanPlayer.resetScore();
        computerPlayer.resetScore();
        gameRounds.clear();
        currentGameRound = null;
        isGameOver = false;
        winner = null;
        probabilityOfComputerWinning = 0.5;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public GameRound getCurrentGameRound() {
        return currentGameRound;
    }

    public Player getHumanPlayer() {
        return humanPlayer;
    }

    public Player getComputerPlayer() {
        return computerPlayer;
    }

    public static GameEngine getInstance() {
        return gameEngine;
    }

    public Player getWinner() {
        return winner;
    }

    public void setRoundsToWin(int roundsToWin) {
        ROUNDS_TO_WIN = roundsToWin;
    }

    public void setProbabilityOfComputerWinning(double probabilityOfComputerWinning) {
        this.probabilityOfComputerWinning = probabilityOfComputerWinning;
    }
}
