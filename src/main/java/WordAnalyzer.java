public class WordAnalyzer {


    public WordAnalyzer() {
    }

    public static boolean isLetterInCorrectPosition(char letterGuess, char[] word, int indexWord) {

        boolean letterIsGuessed = false;

        if (letterGuess == word[indexWord]) {
            letterIsGuessed = true;
        }
        return letterIsGuessed;
    }

    public static boolean isLetterInWord(char letterGuess, DictionaryEntry entry) {

        boolean letterIsInWord = false;
        char[] word = entry.getWord();


        for (int i = 0; i < word.length; i++) {

            if (word[0] == letterGuess) {
                letterIsInWord = true;
            }
        }

        return letterIsInWord;
    }

    public static int countOccurrencesInWord(char letterGuess, char[] word) {
        int numberOfLetter = 0;

        for (int i = 0; i < word.length; i++) {
            if (word[i] == letterGuess) {
                numberOfLetter++;
            }
        }

        return numberOfLetter;
    }
}
