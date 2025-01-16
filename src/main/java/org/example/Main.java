package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HangmanGame hangmanGame = new HangmanGame();
        Scanner scanner = new Scanner(System.in);

        while(!hangmanGame.isGameOver()) {
            System.out.println("Write letter: ");
            String letter = scanner.next();
            scanner.nextLine();
            hangmanGame.findLetterInWord(letter);
            hangmanGame.drawWord();
        }
    }

}