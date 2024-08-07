package Task1;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;
    private static final int MAX_ATTEMPTS = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundsWon = 0;
        int totalRounds = 0;

        while (true) {
            totalRounds++;
            boolean won = playRound(random);
            if (won) {
                roundsWon++;
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.printf("Game over! You won %d out of %d rounds.%n", roundsWon, totalRounds);
        scanner.close();
    }

    private static boolean playRound(Random random) {
        int numberToGuess = generateRandomNumber(random);
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        System.out.printf("Guess the number between %d and %d.%n", MIN_VALUE, MAX_VALUE);

        while (attempts < MAX_ATTEMPTS) {
            int guess = getUserGuess(scanner);
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.printf("Congratulations! You guessed the number %d correctly in %d attempts.%n", numberToGuess, attempts);
                return true;
            }

            int remainingAttempts = MAX_ATTEMPTS - attempts;
            if (remainingAttempts > 0) {
                System.out.printf("You have %d attempt(s) left.%n", remainingAttempts);
            } else {
                System.out.printf("Sorry, you've used all %d attempts. The correct number was %d.%n", MAX_ATTEMPTS, numberToGuess);
            }
        }

        return false;
    }

    private static int generateRandomNumber(Random random) {
        return MIN_VALUE + random.nextInt(MAX_VALUE - MIN_VALUE + 1);
    }

    private static int getUserGuess(Scanner scanner) {
        while (true) {
            System.out.print("Enter your guess: ");
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
