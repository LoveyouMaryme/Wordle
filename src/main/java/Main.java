import com.sun.source.util.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int askNumberOfLetters() {


        Scanner readNumberOfLetters = new Scanner(System.in);
        boolean goodNumberOfLetters;
        String input = "0";
        int numberOfLetters = 0;

        do {

            System.out.print("Enter the number of letters you want to guess: ");
            goodNumberOfLetters = true;
            try {
                input = readNumberOfLetters.nextLine();
                numberOfLetters = Integer.parseInt(input);
                if (numberOfLetters <= 0) {
                    goodNumberOfLetters = false;
                    System.out.println("You cannot enter a negative number");
                }
            } catch (NumberFormatException e) {
                System.out.println("You didn't enter a number. Try again.");
                goodNumberOfLetters = false;
            }

            System.out.println("\nYou chose to guess " + numberOfLetters + " letters.\n");

        } while (!goodNumberOfLetters);

        return numberOfLetters;

    }

    public static boolean askIsGameDone() {
        boolean isGameDone = false;
        Scanner responsePlayer = new Scanner(System.in);
        String input;
        boolean goodAnswer;

        do {

            System.out.print("Do you still want to play?  ");
            goodAnswer = true;
            input = responsePlayer.nextLine();

            if (!input.trim().equalsIgnoreCase("yes") && !input.trim().equalsIgnoreCase("no")) {
                System.out.println("You have to either say yes or no");
                goodAnswer = false;
            } else {
                if (input.trim().equalsIgnoreCase("no")) {
                    isGameDone = true;
                }
            }

            System.out.println();

        } while (!goodAnswer);


        return isGameDone;

    }

    public static DictionaryEntry randomWord(int numberOfGuesses) {
        ArrayList<DictionaryEntry> availableWords;
        int randomNumber;
        DictionaryEntry randomWord;

        availableWords = new FetchWords(numberOfGuesses).readDictionary(FetchWords.DICTIONARY_FILE);
        randomNumber = (int) (Math.random() * availableWords.size());

        randomWord = availableWords.get(randomNumber);
        return randomWord;
    }


    public static PlayerGuess askPlayerGuess(char[] randomWordToGuess) {
        Scanner readNumberOfLetters = new Scanner(System.in);
        boolean validGuess;
        char[] input;
        int numberOfLetters = 0;
        PlayerGuess playerOfficialGuess = null;

        do {
            System.out.printf("Enter your %d%s guess: ", PlayerGuess.getNumberOfGuesses() + 1, Affichage.formatSuffixes(PlayerGuess.getNumberOfGuesses() + 1));

            validGuess = true;
            input = readNumberOfLetters.nextLine().toCharArray();


            if (input.length != randomWordToGuess.length) {
                validGuess = false;
                System.out.println("You cannot enter a word with more or less letters than the guess");
            } else {
                playerOfficialGuess = new PlayerGuess(input);

            }


        } while (!validGuess);

        return playerOfficialGuess;

    }


    public static void main(String[] args) {

        int numberOfLetters;
        boolean isGameContinuing = true;
        PlayerGuess playerChoice;
        boolean wordIsFound = false;
        String defintionRandomWord = "";


        while (isGameContinuing) {
            numberOfLetters = askNumberOfLetters();


            if (isGameContinuing) {
                GuessManager playerChoices = new GuessManager(numberOfLetters);
                DictionaryEntry randomWord = randomWord(numberOfLetters);
                char[] pickRandomWord = randomWord.getWord();
                defintionRandomWord = randomWord.getDefiniton();
                System.out.println("Your word has been chosen\n");
                GuessTracker playerProgression = new GuessTracker(randomWord);
                PlayerGuess.resetNumberOfGuesses();

                while (PlayerGuess.getNumberOfGuesses() < numberOfLetters && !wordIsFound) {
                    playerChoice = askPlayerGuess(pickRandomWord);

                    playerChoices.addGuess(playerChoice);

                    System.out.println("You found those letters");
                    System.out.println(playerProgression.keepTrackGoodGuesses(pickRandomWord, playerChoice.getGuess()));

                    System.out.println("The word doesn't have those letters");
                    System.out.println(playerProgression.keepTrackBadGuesses(pickRandomWord, playerChoice.getGuess()));

                    wordIsFound = playerProgression.isTheWordFound(pickRandomWord, playerChoice.getGuess());


                }

                if (!wordIsFound) {
                    System.out.printf("The word was %s\n", Arrays.toString(pickRandomWord));
                }
                System.out.printf("Definition : %s\n", defintionRandomWord);


                isGameContinuing = !(askIsGameDone());
                wordIsFound = false;


            }


        }


    }
}
