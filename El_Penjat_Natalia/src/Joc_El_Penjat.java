import java.util.Arrays;
import java.util.Random;

public class Joc_El_Penjat {
    public static void main(String[] wordsArray) {
        System.out.println("GAME STARTS");

        int lives = 6;
        String[] words;
        String chosenWord = wordsArray();
        char[] letters = wordMasking(chosenWord);
        wordGuessing(chosenWord, letters);
    }

    private static String wordsArray() {
        String[]words = new String[]{"party", "winter", "touch", "next", "coat", "love", "snail", "care", "brief", "guitar", "rhythm", "free", "prince", "princess", "king", "relation", "sword", "shield", "freezing", "mouth", "eye", "trick", "farm", "week", "weekend", "experience", "reflection", "factory", "pantry", "palace"};

        //Picking of a random word:
        String chosenWord = words[(int) (Math.random() * words.length)];

        System.out.println(chosenWord);

        return chosenWord;
    }

    private static char[] wordMasking(String chosenWord) {
        //Masking of the word:
        char[] letters = new char[chosenWord.length()];
        for(int i = 0; i < letters.length; i++) {
            letters[i] = '_';
            System.out.print(letters[i]);
        }
        return letters;
    }

    private static int wordGuessing(String chosenWord, char[] letters) {
        int lives = 6;

        while (lives > 0) {
            int position = 0;
            boolean guess = false;
            char inputLetter;

            //Player's input of a letter:
            System.out.println("\nLives: " + lives);
            System.out.println("\nGuess a letter: ");
            inputLetter = Teclat.llegirChar();

            //Checking if the letter is in the word:
            for(int i = 0; i < chosenWord.length(); i++) {
                char letter = chosenWord.charAt(i);

                if(letter == inputLetter) {
                    letters[i] = letter;
                    guess = true;
                }
            }

            if(guess) {
                System.out.println(letters);

            } else {
                System.out.println("Wrong letter.");
                System.out.println(letters);
                lives = lives - 1;
            }
        }

        System.out.println("\nGAME OVER");

        return lives;
    }
}


