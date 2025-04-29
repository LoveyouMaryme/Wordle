import java.io.*;
import java.util.ArrayList;

public class Dictionary {

    public static final String DICTIONARY_FILE = "ressources/data/dict.csv";
    public Word[] dictionary;

    public static String wordAndDefinition;


    private int numberOfLetters;

    public Dictionary(int numberOfGuesses, int numberOfWords) {
        this.numberOfLetters = numberOfGuesses;
    }


    public Word[] readDictionary(String filename) {

        String currentWord;
        String word;
        String definition;
        BufferedReader reader;
        int nbOfLines = 0;
        boolean rightLen = true;
        ArrayList<Word> words = new ArrayList<>();


        try {
            reader = new BufferedReader(new FileReader(filename));

            do {
                rightLen = true;

                currentWord = reader.readLine();

                if (nbOfLines != 0) { //Don't add the header


                    word = currentWord.substring(0, currentWord.indexOf(","));
                    definition = currentWord.substring(currentWord.indexOf(",") + 1).replace("\"", "");

                    Word newWord = new Word(word, definition);

                    if (word.length() != this.numberOfLetters) {
                        rightLen = false;
                    } else {
                        words.add(newWord);
                    }

                }

                nbOfLines++;


            } while (reader.ready());

            reader.close();




        } catch (FileNotFoundException e) {
            System.out.println("The file was not found ):" + e);

        } catch (IOException e) {
            System.out.println("Bad reading");

        }

        return words.toArray(new Word[0]);
    }






    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public void setNumberOfLetters(int numberOfLetters) {
        this.numberOfLetters = numberOfLetters;
    }

    public Word[] getDictionary(){
        return dictionary;
    }
}
