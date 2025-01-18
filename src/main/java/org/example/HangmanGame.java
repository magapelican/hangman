package org.example;

public class HangmanGame {

    private static int SCORES = 7;
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
        wonOrLost();
    }

    private void wonOrLost() {
        if (SCORES == 0) {
            System.out.println("You lost mate");
            System.out.println("Word was - " + wordToGuess);
        }
        else {
            System.out.println("You won mate");
        }
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
        System.out.println();
        drawHangman();
    }

    private void drawHangman() {
        String[] hangMans = {
                "----------\n1      |\n1      |\n1\n1\n1\n1\n1",
                "----------\n1      |\n1      |\n1      0\n1\n1\n1\n1",
                "----------\n1      |\n1      |\n1      0\n1      |\n1\n1\n1",
                "----------\n1      |\n1      |\n1      0\n1      |\n1      |\n1\n1",
                "----------\n1      |\n1      |\n1      0\n1      |\n1      |\n1     /\n1",
                "----------\n1      |\n1      |\n1      0\n1      |\n1      |\n1     / \\\n1      ",
                "----------\n1      |\n1      |\n1      0\n1     /|\n1      |\n1     / \\\n1      ",
                "----------\n1      |\n1      |\n1      0\n1     /|\\\n1      |\n1     / \\\n1      ",
        };

        switch(SCORES) {
            case 0:
                System.out.print(hangMans[7]);
                break;
            case 1:
                System.out.print(hangMans[6]);
                break;
            case 2:
                System.out.print(hangMans[5]);
                break;
            case 3:
                System.out.print(hangMans[4]);
                break;
            case 4:
                System.out.print(hangMans[3]);
                break;
            case 5:
                System.out.print(hangMans[2]);
                break;
            case 6:
                System.out.print(hangMans[1]);
                break;
            case 7:
                System.out.print(hangMans[0]);
                break;
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getSCORES() {
        return SCORES;
    }

}
