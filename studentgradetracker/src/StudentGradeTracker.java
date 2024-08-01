import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> grades = new ArrayList<>();
        String input;

        System.out.println("Enter student grades. Type 'done' to finish:");

        // Input loop
        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                double grade = Double.parseDouble(input);
                grades.add(grade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid grade or 'done' to finish:");
            }
        }

        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
        } else {
            // Create a DoubleStream from the grades list
            DoubleStream gradeStream = grades.stream().mapToDouble(Double::doubleValue);

            // Compute statistics using summaryStatistics
            DoubleSummaryStatistics stats = gradeStream.summaryStatistics();

            // Display results
            System.out.println("Grades Summary:");
            System.out.printf("Average: %.2f\n", stats.getAverage());
            System.out.printf("Highest: %.2f\n", stats.getMax());
            System.out.printf("Lowest: %.2f\n", stats.getMin());
        }

        scanner.close();
    }
}
