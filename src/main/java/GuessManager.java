public class GuessManager {

    private final int numberOfGuesses;
    private final PlayerGuess[] playerGuessesBank;

    public GuessManager(int numberOfGuesses) {
        this.numberOfGuesses = numberOfGuesses;
        this.playerGuessesBank = new PlayerGuess[numberOfGuesses];
    }

    public PlayerGuess[] getPlayerGuessesBank() {
        return playerGuessesBank;
    }

    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }
}

