import java.util.InputMismatchException;
import java.util.Scanner;

public class GetInput {

    // Method to get input from the user with recursion
    public static int getInput(Scanner scanner) {
        try {
            int input = scanner.nextInt();
            if (input >= 1 && input <= 10) {
                return input;  // Valid input
            } else {
                System.out.println("Please enter a number between 1 and 10.");
                return getInput(scanner);  // Recursive call for invalid input
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next();  // Clear the invalid input
            return getInput(scanner);  // Recursive call for invalid input
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please enter a number between 1 and 10:");
        int input = getInput(scanner);  // Call the getInput method
        System.out.println("You entered: " + input);  // Print the valid input
        scanner.close();  // Close the Scanner
    }
}
