import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Declare an array of type int named dataPoints with a length of 100
        int[] dataPoints = new int[100];

        // Initialize each element in the dataPoints array to a random value between 1 and 100
        Random random = new Random();
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = random.nextInt(100) + 1; // Random value between 1 and 100
        }

        // Prompt the user again for a value between 1 and 100
        int userValue = SafeInput.getRangedInt("Enter an integer between 1 and 100: ", 1, 100);

        // Code a loop that iterates through the dataPoints array to find the user's value
        int position = -1; // Initialize position to -1, indicating not found
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue) {
                position = i;
                break; // Short circuit the loop if the value is found
            }
        }

        // Display the result whether the value is found or not
        if (position != -1) {
            System.out.println("The value " + userValue + " was found at array index " + position + ".");
        } else {
            System.out.println("The value " + userValue + " is not in the array.");
        }

        // Code a loop to scan for the minimum and maximum values in the dataPoints array
        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }

        // Display the minimum and maximum values to the user
        System.out.println("The minimum value in the array is: " + min);
        System.out.println("The maximum value in the array is: " + max);

        // Call getAverage method to calculate and display the average of dataPoints
        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));

        // Display the values in the dataPoints array separated by " | "
        for (int i = 0; i < dataPoints.length; i++) {
            System.out.print(dataPoints[i]);
            if (i < dataPoints.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println(); // Move to the next line

        // Calculate the sum and the average of the values in dataPoints
        int sum = 0;
        for (int num : dataPoints) {
            sum += num;
        }
        double average = (double) sum / dataPoints.length;

        // Output/display the sum and the calculated average
        System.out.println("The sum of the random array dataPoints is: " + sum);
        System.out.printf("The average of the random array dataPoints is: %.2f\n", average);
    }

    // Method to calculate the average of an array of integers
    public static double getAverage(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return (double) sum / values.length;
    }
    public class SafeInput {
        private static final Scanner scanner = new Scanner(System.in);

        public static int getRangedInt(String prompt, int min, int max) {
            int input;
            boolean valid;
            do {
                System.out.print(prompt);
                while (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid integer.");
                    scanner.next();
                    System.out.print(prompt);
                }
                input = scanner.nextInt();
                valid = input >= min && input <= max;
                if (!valid) {
                    System.out.println("Please enter an integer between " + min + " and " + max + ".");
                }
            } while (!valid);
            return input;
        }
    }
}