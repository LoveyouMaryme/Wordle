import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class FetchWordsTest {

    @Test
    void testGetNumberOfLetters() {
        FetchWords dict = new FetchWords(5);
        assertEquals(5, dict.getNumberOfLetters());
    }


    @Test
    void testLenOfWords(){
        FetchWords dict = new FetchWords(5);
        ArrayList<DictionaryEntry> words = dict.readDictionary(FetchWords.DICTIONARY_FILE);

        int index = 0;
        for (DictionaryEntry word : words) {
            assertEquals(5, words.get(index).getWord().length, "Word length mismatch: " + word);
            index++;
        }

    }



}