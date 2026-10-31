import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    // Difficulty settings: name, max number, max attempts
    private static final String[] LEVEL_NAMES = {"Easy", "Medium", "Hard"};
    private static final int[] LEVEL_MAX = {50, 100, 200};
    private static final int[] LEVEL_ATTEMPTS = {10, 7, 5};

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("     NUMBER GUESSING GAME");
        System.out.println("=================================");

        List<String> history = new ArrayList<>();
        int round = 0;
        boolean playAgain;

        do {
            round++;
            int level = chooseDifficulty();
            int maxNumber = LEVEL_MAX[level];
            int maxAttempts = LEVEL_ATTEMPTS[level];

            // New random number each round
            int secret = random.nextInt(maxNumber) + 1;

            System.out.println();
            System.out.println("--- Round " + round + " (" + LEVEL_NAMES[level] + ") ---");
            System.out.println("I'm thinking of a number between 1 and " + maxNumber
                    + ". You have " + maxAttempts + " attempts.");

            int attempts = 0;
            boolean won = false;

            while (attempts < maxAttempts && !won) {
                int remaining = maxAttempts - attempts;
                int guess = readGuess("Attempt " + (attempts + 1) + "/" + maxAttempts
                        + " (" + remaining + " left) - Enter your guess: ", 1, maxNumber);
                attempts++;

                if (guess > secret) {
                    System.out.println("Too High!");
                } else if (guess < secret) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Correct!");
                    won = true;
                }
            }

            if (won) {
                history.add("Round " + round + " [" + LEVEL_NAMES[level] + "] - guessed in "
                        + attempts + (attempts == 1 ? " attempt" : " attempts"));
            } else {
                System.out.println("You Lost! The number was " + secret + ".");
                history.add("Round " + round + " [" + LEVEL_NAMES[level] + "] - lost (number was "
                        + secret + ")");
            }

            printSummary(history);
            playAgain = askPlayAgain();
        } while (playAgain);

        System.out.println();
        System.out.println("Thanks for playing! Final results:");
        printSummary(history);
        scanner.close();
    }

    private static int chooseDifficulty() {
        System.out.println();
        System.out.println("Choose difficulty:");
        for (int i = 0; i < LEVEL_NAMES.length; i++) {
            System.out.println("  " + (i + 1) + ". " + LEVEL_NAMES[i] + " (1-" + LEVEL_MAX[i]
                    + ", " + LEVEL_ATTEMPTS[i] + " attempts)");
        }
        return readGuess("Enter 1, 2 or 3: ", 1, 3) - 1;
    }

    // Reads an integer within [min, max], re-prompting on invalid input
    private static int readGuess(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("That's not a valid number. Try again.");
            }
        }
    }

    private static boolean askPlayAgain() {
        while (true) {
            System.out.print("\nPlay again? (yes/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("yes") || answer.equals("y")) {
                return true;
            }
            if (answer.equals("no") || answer.equals("n")) {
                return false;
            }
            System.out.println("Please type yes or no.");
        }
    }

    private static void printSummary(List<String> history) {
        System.out.println();
        System.out.println("=== Score Summary ===");
        for (String entry : history) {
            System.out.println(entry);
        }
    }
}
