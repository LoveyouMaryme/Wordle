import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.exceptions.CsvValidationException;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Dictionary {

    public static final String DICTIONARY_FILE = "ressources/data/dict.csv";
    public Word[] dictionary;

    public static String wordAndDefinition;


    private int numberOfLetters;

    public Dictionary(int numberOfLetters) {
        this.numberOfLetters = numberOfLetters;
    }


    public ArrayList<Word> readDictionary(String filename) {

        String currentWord;
        String word;
        String definition;
        CSVReader csvReader;
        ArrayList<Word> words = new ArrayList<>();


        try {

            csvReader = new CSVReaderBuilder(new FileReader(filename))
                    .withCSVParser(new CSVParserBuilder()
                            .withSeparator(',')
                            .withQuoteChar('"')
                            .build())
                    .withSkipLines(1)
                    .build();


            while (csvReader.readNext() != null){

                currentWord = Arrays.toString(csvReader.readNext());

                    word = currentWord.substring(0, currentWord.indexOf(",")).replaceAll("\\[", "");
                    definition = currentWord.substring(currentWord.indexOf(",") + 2).replaceAll("]", "");
                    ;

                    Word newWord = new Word(word, definition);

                    if (word.length() == this.numberOfLetters) {
                        words.add(newWord);

                    }


            }



            csvReader.close();


        } catch (FileNotFoundException e) {
            System.out.println("The file was not found ):" + e);

        } catch (IOException e) {
            System.out.println("Bad reading");

        } catch (CsvValidationException e) {
            System.out.println("Csv has an issue");
        }


        return words;
    }


    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public void setNumberOfLetters(int numberOfLetters) {
        this.numberOfLetters = numberOfLetters;
    }

    public Word[] getDictionary() {
        return dictionary;
    }
}
