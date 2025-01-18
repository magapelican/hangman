package org.example;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HangmanGame hangmanGame;

        while(true) {
            hangmanGame = new HangmanGame();

            if (enterGame() != 1) {
                System.exit(0);
            }

            while (!hangmanGame.isGameOver()) {
                System.out.println("You got - " + hangmanGame.getSCORES() + " scores");
                System.out.println("Write letter: ");
                String letter = scanner.next();
                hangmanGame.findLetterInWord(letter);
                hangmanGame.drawWord();
                System.out.println();
            }
        }
    }

    public static int enterGame() {
        System.out.println("Menu:\n1. Play hangman\n2. Quit the game");
        int playerChoise = scanner.nextInt();

        return playerChoise;
    }

}