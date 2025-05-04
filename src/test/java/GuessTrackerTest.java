import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessTrackerTest {

    @Test
    void keepTrackGoodGuesses() {

            DictionaryEntry testEntry = new DictionaryEntry("proud", "sentiment of humans");

            GuessTracker testGuessTracker  = new GuessTracker(testEntry);

            char[] test = testGuessTracker.keepTrackGoodGuesses("brave".toCharArray(), "proud".toCharArray());
            for(int i = 0; i < 5; i++){
                System.out.println(test[i]);
            }

    }
}