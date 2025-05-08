import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GuessManagerTest {

    @Test
    void addGuesstoBankGuess() {
        PlayerGuess guess1 = new PlayerGuess("love".toCharArray());
        GuessManager bankGuess = new GuessManager(5);
        assertEquals(true, bankGuess.addGuess(guess1));

    }

    @Test
    void getPlayerGuessesBank() {
    }

    @Test
    void getNumberOfGuesses() {
    }
}