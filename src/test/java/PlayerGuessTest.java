import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerGuessTest {

    @Test
    void guessCounter() {

        char[] input1 = "guessUn".toCharArray();
        char[] input2 = "guessDeux".toCharArray();
        char[] guess1 = new PlayerGuess(input1).getGuess();
        char[] guess2 = new PlayerGuess(input2).getGuess();
        System.out.println(PlayerGuess.getNumberOfGuesses());

    }

    @Test
    void getGuess() {
    }
}