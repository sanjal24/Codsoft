import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    String question;
    String[] options;
    int correctOptionIndex;

    public QuizQuestion(String question, String[] options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }
}

class Quiz {
    private QuizQuestion[] questions;
    private int userScore;

    public Quiz(QuizQuestion[] questions) {
        this.questions = questions;
        this.userScore = 0;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (QuizQuestion question : questions) {
            displayQuestion(question);

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up! Moving to the next question.");
                    evaluateAnswer(question, 0);
                }
            }, 15000);

            System.out.print("Your answer (1-" + question.options.length + "): ");
            int userAnswer = scanner.nextInt();

            timer.cancel();

            evaluateAnswer(question, userAnswer);
        }
        displayResult();
    }

    private void displayQuestion(QuizQuestion question) {
        System.out.println("\n" + question.question);
        for (int i = 0; i < question.options.length; i++) {
            System.out.println((i + 1) + ". " + question.options[i]);
        }
    }

    private void evaluateAnswer(QuizQuestion question, int userAnswer) {
        if (userAnswer == question.correctOptionIndex + 1) {
            System.out.println("Correct!\n");
            userScore++;
        } else {
            System.out.println("Incorrect. The correct answer is: " + (question.correctOptionIndex + 1) + "\n");
        }
    }

    private void displayResult() {
        System.out.println("Quiz completed!");
        System.out.println("Your final score: " + userScore + " out of " + questions.length);
    }
}

public class SimpleQuizApp {
    public static void main(String[] args) {
        QuizQuestion[] quizQuestions = {
                new QuizQuestion("What is 7 + 2?", new String[] { "3", "1", "9" }, 2),
                new QuizQuestion("Who is Prime Minister of India?",
                        new String[] { "Meloni", "Narendra MOdi", "YOgi Adityanath" },
                        1),
                new QuizQuestion("Which is the largest snake?", new String[] { "Hiten", "Green Anaconda", "Omkar" }, 1)
        };

        Quiz quiz = new Quiz(quizQuestions);
        quiz.startQuiz();
    }
}
