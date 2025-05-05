import java.util.ArrayList;

public class GuessTracker {

    private  char[] goodGuessesTracker;
    private ArrayList<Character> badGuessesTracker;



    public GuessTracker(DictionaryEntry randomWord) {
        this.goodGuessesTracker = new char[randomWord.getWord().length];
        this.badGuessesTracker = new ArrayList<Character>();



    }

    public char[] getGoodGuessesTracker() {
        return goodGuessesTracker;
    }

    public char[] keepTrackGoodGuesses(char[] randomWord, char[] playerGuess){

        for(int i = 0; i < randomWord.length; i++){
            if(randomWord[i] == playerGuess[i]){
                goodGuessesTracker[i] = playerGuess[i];
            }
        }
        return goodGuessesTracker;
    }

    public ArrayList<Character>  keepTrackBadGuesses(char[] randomWord, char[] playerGuess){

        for(int i = 0; i < randomWord.length; i++){
            if(!WordAnalyzer.isLetterInWord(randomWord[i], playerGuess)){
                badGuessesTracker.add(randomWord[i]);
            }
        }
        return badGuessesTracker;
    }




}
