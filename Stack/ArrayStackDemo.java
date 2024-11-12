package cheatsheet.Stack;

import javax.swing.*;
import java.util.EmptyStackException;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>();
        boolean running = true;

        while (running) {
            // Define the menu options
            String[] options = {"Push", "Pop", "Peek", "Is Empty", "Clear", "Print", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose Stack Operation", "Array Stack Demo",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            try {
                switch (choice) {
                    case 0: // Push
                        String input = JOptionPane.showInputDialog("Enter element to push:");
                        if (input != null) {
                            stack.push(input);
                            JOptionPane.showMessageDialog(null, input + " pushed onto the stack.");
                        }
                        break;
                    case 1: // Pop
                        String poppedElement = stack.pop();
                        JOptionPane.showMessageDialog(null, "Popped: " + poppedElement);
                        break;
                    case 2: // Peek
                        String topElement = stack.peek();
                        JOptionPane.showMessageDialog(null, "Top element: " + topElement);
                        break;
                    case 3: // Is Empty
                        JOptionPane.showMessageDialog(null, "Is Empty: " + stack.isEmpty());
                        break;
                    case 4: // Clear
                        stack.clear();
                        JOptionPane.showMessageDialog(null, "Stack cleared.");
                        break;
                    case 5: // Print
                        JOptionPane.showMessageDialog(null, stack.toString());
                        break;
                    case 6: // Exit
                        running = false;
                        break;
                    default:
                        break;
                }
            } catch (EmptyStackException e) {
                JOptionPane.showMessageDialog(null, "Stack is empty. Cannot perform this operation.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
