import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int askNumberOfLetters() {


        Scanner readNumberOfLetters = new Scanner(System.in);
        boolean goodNumberOfLetters;
        String input = "0";
        int numberOfLetters = 0;

        do {

            System.out.print("Enter the number of letters you want to guess: ");
            goodNumberOfLetters = true;
            try {
                input = readNumberOfLetters.nextLine();
                numberOfLetters = Integer.parseInt(input);
                if(numberOfLetters <= 0){
                    goodNumberOfLetters = false;
                    System.out.println("You cannot enter a negative number");
                }
            } catch (NumberFormatException e) {
                System.out.println("You didn't enter a number. Try again.");
                goodNumberOfLetters = false;
            }



            System.out.println("\nYou chose to guess " + numberOfLetters + " letters.\n");


        } while (!goodNumberOfLetters);

        return numberOfLetters;

    }

    public static boolean askIsGameDone() {
        boolean isGameDone = false;
        Scanner responsePlayer = new Scanner(System.in);
        String input;
        boolean goodAnswer;

        do {

            System.out.print("Do you still want to play?  ");
            goodAnswer = true;
            input = responsePlayer.nextLine();

            if (!input.trim().equalsIgnoreCase("yes") && !input.trim().equalsIgnoreCase("no")) {
                System.out.println("You have to either say yes or no");
                goodAnswer = false;
            } else {
                if (input.trim().equalsIgnoreCase("no")) {
                    isGameDone = true;
                }
            }

            System.out.println();

        } while (!goodAnswer);


        return isGameDone;

    }


    public static void main(String[] args) {

        int numberOfLetters;
        boolean isGameContinuing = true;


        while (isGameContinuing) {
            numberOfLetters = askNumberOfLetters();
            //If number of letters = 0, stop the game


            isGameContinuing = !(askIsGameDone());
            if(isGameContinuing) {
                // one day write how many guesses she could have with that choice
                //System.out.println("There are")
            }




        }


    }
}
