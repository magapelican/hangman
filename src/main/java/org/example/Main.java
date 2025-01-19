package org.example;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException{
        HangmanGame hangmanGame;

        while(true) {
            int playersChoise = enterGame();

            if (playersChoise == 3) {
                System.exit(0);
            }

            try {
                hangmanGame = new HangmanGame(playersChoise);
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                continue;
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
        System.out.println("Menu:\n1. Play hangman with country names\n2. Play hangman with fruits names\n3. Quit the game");
        int playerChoise = scanner.nextInt();

        return playerChoise;
    }

}