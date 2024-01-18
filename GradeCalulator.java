import java.util.InputMismatchException;
import java.util.Scanner;

public class GradeCalulator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter marks obtained (out of 100) in each subject:");
        int numofSubjects = 5;
        int totalMarks = 0;

        for (int i = 1; i <= numofSubjects; i++) {
            int marks;
            while (true) {
                try {
                    System.out.print("Subject " + i + ": ");
                    marks = input.nextInt();

                    // Ensure the marks are within the valid range (0-100)
                    if (marks < 0 || marks > 100) {
                        System.out.println("Marks should be between 0 and 100. Enter again.");
                        continue;
                    }
                    break; // Break the loop if input is valid
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    input.next(); // consume the invalid input
                }
            }

            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / numofSubjects;

        char grade = calculateGrade(averagePercentage);
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
