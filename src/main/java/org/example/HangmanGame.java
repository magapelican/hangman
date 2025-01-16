package org.example;

public class HangmanGame {

    private static int SCORES = 9;
    private String wordToGuess;
    private boolean[] guessedLetters;
    private boolean gameOver = false;

    HangmanGame() {
        this.wordToGuess = new Word().getWord();
        guessedLetters = new boolean[wordToGuess.length()];
    }

    public void findLetterInWord(String letter) {
        int index = wordToGuess.indexOf(letter);
        if (index == -1) {
            SCORES--;
        }


        while(index != -1) {
            guessedLetters[index] = true;
            index++;
            index = wordToGuess.indexOf(letter, index);
        }

        controlGameState();

    }

    private void controlGameState() {
        if (SCORES > 0) {
            for (int i = 1; i < guessedLetters.length; i++) {
                if (guessedLetters[i] != true) {
                    return;
                }
            }
        }

        gameOver = true;
    }

    public void drawWord() {
        for (int i = 0; i < guessedLetters.length; i++) {
            if (guessedLetters[i] == true) {
                System.out.print(wordToGuess.charAt(i));
            }
            else {
                System.out.print("*");
            }
        }

    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getSCORES() {
        return SCORES;
    }


}
