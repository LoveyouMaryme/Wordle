import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int askNumberOfLetters(){


        Scanner readNumberOfLetters = new Scanner(System.in);
        boolean goodNumberOfLetters;
        String input;
        int numberOfLetters = 0;

        do {

            System.out.print("Enter the number of letters you want to guess: ");

            try{
            goodNumberOfLetters = true;
            input = readNumberOfLetters.nextLine();
            numberOfLetters = Integer.parseInt(input);
            System.out.println();
            System.out.println("You chose to guess " + numberOfLetters + " letters.");

            } catch (NumberFormatException e){
                System.out.println("You didn't enter a number. Try again.");
                goodNumberOfLetters = false;
            }

            System.out.println();

        }while(!goodNumberOfLetters);

        return numberOfLetters;

    }
    public static void main(String[] args) {

        int numberOfLetters;

        numberOfLetters = askNumberOfLetters();
        //If number of letters = 0, stop the game


        // one day write how many guesses she could have with that choice
        //System.out.println("There are")





        }
    }
