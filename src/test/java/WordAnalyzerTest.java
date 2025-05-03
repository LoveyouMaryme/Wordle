import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordAnalyzerTest {

    @Test
    void isLetterInCorrectPosition() {
        char[] input = "azole".toCharArray();
        char[] wordApple = new DictionaryEntry("apple", "a fruit").getWord();
        char[] guess = new PlayerGuess(input).getGuess();
        int index = 0;

        for (char i : guess) {
            System.out.println(WordAnalyzer.isLetterInCorrectPosition(i, wordApple, index));
            index++;
        }

    }

    @Test
    void letterIsInWord() {
        assertTrue(WordAnalyzer.isLetterInWord('c', new DictionaryEntry("chaton", "petit animal cute")));
    }

    @Test
    void letterIsNotInWord() {
        assertFalse(WordAnalyzer.isLetterInWord('w', new DictionaryEntry("chaton", "petit animal cute")));
    }


    @Test
    void countOccurrencesInWord() {
        DictionaryEntry wordApple = new DictionaryEntry("apple", "a fruit");

        int numberOfOccurences = WordAnalyzer.countOccurrencesInWord('p', wordApple.getWord());

        assertEquals(2, numberOfOccurences);
    }
}