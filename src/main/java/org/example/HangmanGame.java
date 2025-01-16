package org.example;

public class HangmanGame {

    private String wordToGuess;
    private boolean[] guessedLetters;
    private boolean gameOver;

    HangmanGame() {
        this.wordToGuess = new Word().getWord();
        guessedLetters = new boolean[wordToGuess.length()];
    }

    public void findLetterInWord(String letter) {
        int index = wordToGuess.indexOf(letter);

        while(index >= 0) {
            guessedLetters[index] = true;
            index = wordToGuess.indexOf(letter);
        }

        lookThroughArr();

    }

    private void lookThroughArr() {
        for (int i = 1; i <= guessedLetters.length; i++) {
            if (guessedLetters[i] != guessedLetters[i - 1]) {
                return;
            }
        }

        gameOver = true;
    }

    public void drawWord() {
        for (int i = 0; i <= guessedLetters.length; i++) {
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


}
