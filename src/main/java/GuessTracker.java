public class GuessTracker {

    private  char[] goodGuessesTracker;


    public GuessTracker(DictionaryEntry randomWord) {
        this.goodGuessesTracker = new char[randomWord.getWord().length];
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



}
