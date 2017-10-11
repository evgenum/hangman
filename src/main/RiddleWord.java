package main;

class RiddleWord {
    private final String word;
    private boolean[] hitLetters;

    RiddleWord(String s){
        word = s;
        hitLetters = new boolean[word.length()];

        for(int i = 0;i< hitLetters.length;i++) hitLetters[i]=false;
    }

    String getWord(){
        char[] result = new char[word.length()];

        for(int i = 0;i< word.length();i++){
            result[i] = (hitLetters[i]) ? word.charAt(i):'*';
        }
        System.out.println();
        System.out.print("The word is: ");
        System.out.println(result);
        System.out.println();
        return String.valueOf(result);
    }

    boolean wordComplete(){
        boolean result = true;
        for(int i = 0;i< word.length();i++)
            result = result && hitLetters[i];
        return result;
    }

    boolean checkLetter(char c){
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
