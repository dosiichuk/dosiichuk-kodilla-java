package com.kodilla.rps;

import com.kodilla.rps.ui.UserInterface;

public class RpsRunner {
    private static final UserInterface userInterface = UserInterface.getInstance();

    public static void main(String[] args) {
        userInterface.launchGame();
    }
}
