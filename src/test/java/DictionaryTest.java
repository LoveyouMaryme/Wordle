import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class DictionaryTest {

    @Test
    void testGetNumberOfLetters() {
        Dictionary dict = new Dictionary(5);
        assertEquals(5, dict.getNumberOfLetters());
    }

    @Test
    void testSetNumberOfLetters() {
        Dictionary dict = new Dictionary(3);
        dict.setNumberOfLetters(7);
        assertEquals(7, dict.getNumberOfLetters());
    }

    @Test
    void testLenOfWords(){
        Dictionary dict = new Dictionary(5);
        ArrayList<Word> words = dict.readDictionary(Dictionary.DICTIONARY_FILE);

        int index = 0;
        for (Word word : words) {
            assertEquals(5, words.get(index).getWord().length(), "Word length mismatch: " + word.getWord());
            index++;
        }

    }




}