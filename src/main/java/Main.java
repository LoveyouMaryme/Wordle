import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int askHowManyLetters(){


        Scanner readNumberOfLetters = new Scanner(System.in);
        boolean goodNumberOfLetters = true;
        int numberOfLetters;

        do {
            System.out.print("Enter the number of letters you want to guess");
            numberOfLetters = readNumberOfLetters.nextInt();
            System.out.println();
            System.out.println("You chose to guess" + numberOfLetters + "letters");


            // one day write how many guesses she could have with that choice

        }while(goodNumberOfLetters);

        return numberOfLetters;

    }
    public static void main(String[] args) {

        int numberOfLetters;

        numberOfLetters = askHowManyLetters();





        }
    }
