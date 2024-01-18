import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        System.out.println("WELCOME to Guess the Number game!");

        while (true) {
            play();

            System.out.print("Continue to play again? (yes/no): ");
            Scanner input = new Scanner(System.in);
            String playAgain = input.nextLine().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thank you for playing");
                break;
            }
        }
    }

    private static void play() {
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1;
        int score = 0;
        int ifmaxnoofAttempts = 5;

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("\nGuess the number between 1 and 100: ");
            int guessingnobyuser = input.nextInt();

            if (guessingnobyuser == targetNumber) {
                System.out.println("You guessed the number correctly " + targetNumber + "!");
                break;
            } else if (guessingnobyuser < targetNumber) {
                System.out.println("Number guessed is too low! Try again.");
            } else {
                System.out.println("Number guessed is too high! Try again.");
            }
            score++;
            if (score == ifmaxnoofAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was "
                        + targetNumber + ".");
                break;
            }
        }
        System.out.println("\nYour score for this round: " + score + " attempts");
    }
}
