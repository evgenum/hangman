package main;

import java.util.Random;
import java.util.Scanner;


class Hangman {

    public static void main(String[] args) {

        final int ATTEMPT = 5;
        String[] Dictionary = {"COVENANT","APPLE", "ELEPHANT"};
        int attemptNumber = ATTEMPT;
        Random rand = new Random();
        RiddleWord Riddle = new RiddleWord(Dictionary[rand.nextInt(Dictionary.length)]);
        Scanner scan = new Scanner(System.in);

        while(attemptNumber>0) {
            System.out.println("Guess a letter:");
            char guessLetter = scan.next().toUpperCase().toCharArray()[0];
            if (Riddle.checkLetter(guessLetter)) {
                System.out.println("Hit!");
                Riddle.getWord();
            } else {
                attemptNumber--;
                System.out.println("Missed, mistake " + attemptNumber + " out of " + (ATTEMPT) + ".");
                Riddle.getWord();
            }
            if(Riddle.wordComplete()) break;
        }
        if(Riddle.wordComplete()) System.out.println("You won!");
        else System.out.println("You lost!");

    }

}