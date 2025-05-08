import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GuessTrackerTest {

    @Test
    void keepTrackGoodGuesses() {

            DictionaryEntry testEntry = new DictionaryEntry("proud", "sentiment of humans");

            GuessTracker testGuessTracker  = new GuessTracker(testEntry);

            char[] test = testGuessTracker.keepTrackGoodGuesses("brave".toCharArray(), testEntry.getWord());
            char[] expected = {'_', 'r', '_', '_',  '_'};

            assertEquals(Arrays.toString(expected), Arrays.toString(test));
    }

    @Test
    void badGuessesReturn() {

        DictionaryEntry testEntry = new DictionaryEntry("proud", "sentiment of humans");

        GuessTracker testGuessTracker  = new GuessTracker(testEntry);

        ArrayList<Character> test = testGuessTracker.keepTrackBadGuesses(testEntry.getWord(), "brave".toCharArray());
        ArrayList<Character> expected = new ArrayList<Character>(Arrays.asList('b', 'a', 'v', 'e'));
        assertEquals(expected, test);
    }

    @Test
    void repeatedBadGuessesReturn() {

        DictionaryEntry testEntry = new DictionaryEntry("proud", "sentiment of humans");

        GuessTracker testGuessTracker  = new GuessTracker(testEntry);

        ArrayList<Character> test = testGuessTracker.keepTrackBadGuesses(testEntry.getWord(), "prott".toCharArray());
        ArrayList<Character> expected = new ArrayList<Character>(Arrays.asList('t'));
        assertEquals(expected, test);
    }

    @Test
    void checkIfwordFound(){

        DictionaryEntry testEntry = new DictionaryEntry("proud", "sentiment of humans");

        GuessTracker testGuessTracker  = new GuessTracker(testEntry);

        boolean test = testGuessTracker.isTheWordFound(testEntry.getWord(), "proud".toCharArray());
        boolean expected = true ;
        assertEquals(expected, test);
    }

    @Test
    void wordIsNotFound(){

        DictionaryEntry testEntry = new DictionaryEntry("proud", "sentiment of humans");

        GuessTracker testGuessTracker  = new GuessTracker(testEntry);

        boolean test = testGuessTracker.isTheWordFound(testEntry.getWord(), "prout".toCharArray());
        boolean expected = false ;
        assertEquals(expected, test);
    }

    @Test
    void guessMultipleWords() {

        DictionaryEntry testEntry = new DictionaryEntry("proud", "sentiment of humans");

        GuessTracker testGuessTracker  = new GuessTracker(testEntry);

        char[] test = testGuessTracker.keepTrackGoodGuesses("brave".toCharArray(), testEntry.getWord());
        char[] test2 = testGuessTracker.keepTrackGoodGuesses("prave".toCharArray(), testEntry.getWord());
        char[] expected = {'p', 'r', '_', '_', '_'};

        assertEquals(Arrays.toString(expected), Arrays.toString(test2));
    }

    @Test
    void keepGoodGuesses() {

        DictionaryEntry testEntry = new DictionaryEntry("torsk", "The word \"torsk\" refers to a type of fish");

        GuessTracker testGuessTracker  = new GuessTracker(testEntry);

        char[] test = testGuessTracker.keepTrackGoodGuesses("sotrc".toCharArray(), testEntry.getWord());
        char[] test2 = testGuessTracker.keepTrackGoodGuesses("sport".toCharArray(), testEntry.getWord());
        char[] expected = {'_', 'o', '_', '_', '_'};

        assertEquals(Arrays.toString(expected), Arrays.toString(test2));
    }


}