import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class task1 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("\nWelcome to Number Game.\nThe System will generate a random number between 1-100.");
        System.out.println("You have to guess that random number.");
        System.out.println("Your score will be the number of attempts you took to guess the number.\n");

        System.out.print("Enter the Number of Rounds (between 1-5) you want to play the Game: ");
        int rounds = scanner.nextInt();

        for (int i = 1; i <= rounds; i++) {
            System.out.println("\nRound " + i + " begins ...\n");

            System.out.println("Please Enter the Difficulty Level:");
            System.out.println("1 --> Easy [No limit on number of attempts]");
            System.out.println("2 --> Hard [Limited to 5 attempts]");
            int difficulty = scanner.nextInt();

            int randomNumber = 1 + random.nextInt(100);
            System.out.println("Random Number has been generated...");

            switch (difficulty) {
                case 1:
                    playEasyLevel(scanner, randomNumber);
                    break;
                case 2:
                    playHardLevel(scanner, randomNumber);
                    break;
                default:
                    System.out.println("--- WRONG INPUT ---\nSorry!!! But this round has been wasted.");
                    break;
            }

            System.out.println("ROUND " + i + " is OVER.");
        }

        System.out.println("\nAll the Rounds are over.\nThank you for playing the game.\nHope you enjoyed it.");
        scanner.close();
    }

    private static void playEasyLevel(Scanner scanner, int randomNumber) {
        System.out.println("Opted for Easy Difficulty.\nNo limit on number of attempts\n");
        int attempts = 0;

        while (true) {
            attempts++;
            System.out.print("Enter your guess number " + attempts + ": ");
            int guess = scanner.nextInt();

            if (guess > randomNumber) {
                System.out.println("The number " + guess + " is HIGHER than the generated number. Guess again...");
            } else if (guess < randomNumber) {
                System.out.println("The number " + guess + " is LOWER than the generated number. Guess again...");
            } else {
                System.out.println("The number " + guess + " is EQUAL to the generated number.");
                System.out.println("Congrats! It took you " + attempts + " attempts.");
                break;
            }
        }
    }

    private static void playHardLevel(Scanner scanner, int randomNumber) {
        System.out.println("Opted for Hard Difficulty.\nLimited to 5 attempts.");
        System.out.println("You have 5 attempts to guess the number correctly.\n");
        int attempts = 0;

        while (attempts < 5) {
            attempts++;
            System.out.println("\nNumber of guesses remaining: " + (5 - attempts + 1));
            System.out.print("Enter your guess number " + attempts + ": ");
            int guess = scanner.nextInt();

            if (guess > randomNumber) {
                System.out.println("The number " + guess + " is HIGHER than the generated number. Guess again...");
            } else if (guess < randomNumber) {
                System.out.println("The number " + guess + " is LOWER than the generated number. Guess again...");
            } else {
                System.out.println("The number " + guess + " is EQUAL to the generated number.");
                System.out.println("Congrats! It took you " + attempts + " attempts.");
                return;
            }
        }

        System.out.println("OOPS!!! You were not able to guess the number in 5 attempts.");
        System.out.println("The generated number was " + randomNumber + ". BETTER LUCK NEXT TIME.");
    }
}
