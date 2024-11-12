package cheatsheet.Stack;

import javax.swing.JOptionPane;
import java.util.EmptyStackException;

public class LinkedStackDemo {

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        int choice = 0; // Initialize choice to avoid uninitialized variable error

        do {
            String menu = """
                    Choose an operation:
                    1. Push
                    2. Pop
                    3. Peek
                    4. Is Empty
                    5. Clear
                    6. Print
                    7. Exit
                    """;

            String choiceStr = JOptionPane.showInputDialog(menu);
            if (choiceStr == null) break; // Exit if Cancel is pressed

            try {
                choice = Integer.parseInt(choiceStr);

                switch (choice) {
                    case 1 -> {
                        String newEntry = JOptionPane.showInputDialog("Enter a value to push onto the stack:");
                        if (newEntry != null) {
                            stack.push(newEntry);
                            JOptionPane.showMessageDialog(null, newEntry + " has been pushed onto the stack.");
                        }
                    }
                    case 2 -> {
                        String poppedValue = stack.pop();
                        JOptionPane.showMessageDialog(null, "Popped value: " + poppedValue);
                    }
                    case 3 -> {
                        String topValue = stack.peek();
                        JOptionPane.showMessageDialog(null, "Top value: " + topValue);
                    }
                    case 4 -> {
                        boolean isEmpty = stack.isEmpty();
                        JOptionPane.showMessageDialog(null, "Stack is " + (isEmpty ? "empty." : "not empty."));
                    }
                    case 5 -> {
                        stack.clear();
                        JOptionPane.showMessageDialog(null, "Stack has been cleared.");
                    }
                    case 6 -> {
                        String stackContents = printStack(stack);
                        JOptionPane.showMessageDialog(null, "Stack contents:\n" + stackContents);
                    }
                    case 7 -> JOptionPane.showMessageDialog(null, "Bye");
                    default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please select a number between 1 and 7.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (EmptyStackException e) {
                JOptionPane.showMessageDialog(null, "Error: Stack is empty.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (choice != 7); // Loop until user chooses to exit
    }

    // Helper method to print the stack without modifying it
    private static String printStack(LinkedStack<String> stack) {
        LinkedStack<String> tempStack = new LinkedStack<>();
        StringBuilder stackContents = new StringBuilder();

        while (!stack.isEmpty()) {
            String data = stack.pop();
            stackContents.insert(0, data + "\n");
            tempStack.push(data); // Store values temporarily
        }

        // Restore stack to its original state
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return stackContents.toString();
    }
}
