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
            char[] expected = {0, 'r', 0, 0, 0};

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


}