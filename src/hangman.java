import java.util.Random;
import java.util.Scanner;
import java.io.IOException;


class RiddleWord {
    private String word;
    private boolean[] hitLetters;

    RiddleWord(String s){
        word = s;
        hitLetters = new boolean[word.length()];

        for(int i = 0;i< hitLetters.length;i++) hitLetters[i]=false;
    }

    public void getWord(){
        char[] result = new char[word.length()];

        for(int i = 0;i< word.length();i++){
            result[i] = (hitLetters[i]) ? word.charAt(i):'*';
        }
        System.out.println();
        System.out.print("The word is: ");
        System.out.println(result);
        System.out.println();
    }

    public boolean wordComplete(){
        boolean result = true;
        for(int i = 0;i< word.length();i++)
            result = result && hitLetters[i];
        return result;
    }

    public boolean CheckLetter(char c){
        boolean result = false;

        for(int i = 0;i< word.length();i++){
            if(c == word.charAt(i)){
                hitLetters[i] = true;
                result = true;
            }
        }
        return result;
    }
}

class hangman {

    public static void main(String[] Args) throws IOException {

        final int ATTEMPT = 5;
        String[] Dictionary = {"COVENANT","APPLE", "ELEPHANT"};
        int attemptNumber = ATTEMPT;
        Random rand = new Random();
        RiddleWord Riddle = new RiddleWord(Dictionary[rand.nextInt(Dictionary.length)]);
        Scanner scan = new Scanner(System.in);

        while(attemptNumber>0) {
            System.out.println("Guess a letter:");
            char guessLetter = scan.next().toUpperCase().toCharArray()[0];
            if (Riddle.CheckLetter(guessLetter)) {
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