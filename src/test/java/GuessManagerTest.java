import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessManagerTest {

    @Test
    void addGuess() {
        PlayerGuess guess1 = new PlayerGuess("love".toCharArray());
        GuessManager bankGuess = new GuessManager(5);
        System.out.println(bankGuess.addGuess(guess1));

    }

    @Test
    void getPlayerGuessesBank() {
    }

    @Test
    void getNumberOfGuesses() {
    }
}