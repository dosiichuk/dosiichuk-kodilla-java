package com.kodilla.rps.ui;

import com.kodilla.rps.models.RoundResult;
import com.kodilla.rps.service.GameEngine;

import java.util.Scanner;

public class UserInterface {
    private static final UserInterface userInterface = new UserInterface();
    private final Scanner scanner = new Scanner(System.in);
    private final GameEngine gameEngine = GameEngine.getInstance();
    private boolean isGameOver = false;

    private UserInterface() {

    }

    public void launchGame() {
        isGameOver = gameEngine.isGameOver();
        while (!isGameOver) {
            if (gameEngine.getCurrentGameRound() == null) {
                greetUser();
                takeGameSettings();
            }
            takeUserInput();
            RoundResult roundResult = gameEngine.getCurrentGameRound().getRoundResult();
            displayRoundResult(roundResult);
            displayCurrentScore();
            checkIfGameOver();
        }
    }

    public void greetUser() {
        System.out.println("\nWelcome to Rock-Paper-Scissors game!");
    }

    public void takeGameSettings() {
        System.out.println("Enter your name.");
        String name = scanner.nextLine();
        gameEngine.getHumanPlayer().setName(name);
        System.out.println("Enter the number of rounds to win the game.");
        int roundsToWin;
        try {
            roundsToWin = Integer.parseInt(scanner.nextLine());
            if (roundsToWin < 1) {
                throw new Exception();
            }
            gameEngine.setRoundsToWin(roundsToWin);
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            takeGameSettings();
        }
        System.out.println("Would you like to change the probability of computer winning? Enter y for yes or n for no.");
        String changeProbability = scanner.nextLine();
        if (changeProbability.equals("y")) {
            System.out.println("Enter the probability of computer winning (0.0 - 1.0).");
            double probability;
            try {
                probability = Double.parseDouble(scanner.nextLine());
                if (probability < 0 || probability > 1) {
                    throw new Exception();
                }
                gameEngine.setProbabilityOfComputerWinning(probability);
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                takeGameSettings();
            }
        } else if (!changeProbability.equals("n")) {
            System.out.println("Invalid input. Please try again.");
            takeGameSettings();
        }

    }

    public void takeUserInput() {
        System.out.println("Enter your move! 1 - rock, 2 - paper, 3 - scissors. Enter x to end the game. Enter n to start a new game.");
        int userInput;
        try {
            if (scanner.hasNext("x")) {
                scanner.nextLine(); // consume the prior input
                System.out.println("Are you sure you want to end the game? Enter y for yes or n for no.");
                String endGame = scanner.nextLine();
                if (!endGame.equals("y")) {
                    takeUserInput();
                } else {
                    isGameOver = true;
                    System.out.println("Game over!");
                    System.exit(0);
                }
            }
            if (scanner.hasNext("n")) {
                scanner.nextLine(); // consume the prior input
                System.out.println("Are you sure you want to start a new game? Enter y for yes or n for no.");
                String newGame = scanner.nextLine();
                if (!newGame.equals("y")) {
                    takeUserInput();
                } else {
                    gameEngine.resetGame();
                    launchGame();
                }
            }
            userInput = Integer.parseInt(scanner.nextLine());
            if (userInput < 1 || userInput > 3) {
                throw new Exception();
            }
            gameEngine.processMoves(userInput);
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            takeUserInput();
        }
    }

    public void checkIfGameOver() {
        if (gameEngine.isGameOver()) {
            displayGameOver();
            System.out.println("Would you like to start a new game (press n) or exit the game (press x)?");
            String userInput = scanner.nextLine();
            if (userInput.equals("n")) {
                gameEngine.resetGame();
                launchGame();
            } else if (userInput.equals("x")) {
                isGameOver = true;
                System.out.println("Game over!");
                System.exit(0);
            } else {
                System.out.println("Invalid input. Please try again.");
                checkIfGameOver();
            }
        }
    }

    public void displayRoundResult(RoundResult roundResult) {
        System.out.println("You chose: " + gameEngine.getCurrentGameRound().getHumanPlayerMove() + ", Computer chose: " + gameEngine.getCurrentGameRound().getComputerPlayerMove());
        switch (roundResult) {
            case HUMAN_PLAYER_WIN:
                System.out.println("You win!");
                break;
            case COMPUTER_PLAYER_WIN:
                System.out.println("Computer wins!");
                break;
            case DRAW:
                System.out.println("It's a draw!");
                break;
        }
    }

    public void displayCurrentScore() {
        System.out.println("Current score: " + gameEngine.getHumanPlayer().getName() + " - " + gameEngine.getHumanPlayer().getScore() + ", Computer - " + gameEngine.getComputerPlayer().getScore() + "\n");
    }

    public static UserInterface getInstance() {
        return userInterface;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void displayGameOver() {
        System.out.println("Game over! The winner is: " + gameEngine.getWinner().getName());
    }

}
