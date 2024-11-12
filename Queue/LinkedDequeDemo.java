package cheatsheet.Queue;

import javax.swing.JOptionPane;

public class LinkedDequeDemo {
    public static void main(String[] args) {
        LinkedDeque<String> deque = new LinkedDeque<>();
        boolean running = true;

        while (running) {
            String menu = """
                    Choose an operation:
                    1. Add to Front
                    2. Add to Back
                    3. Remove Front
                    4. Remove Back
                    5. Get Front
                    6. Get Back
                    7. Is Empty
                    8. Clear
                    9. Print Deque
                    10. Exit
                    """;

            String choiceStr = JOptionPane.showInputDialog(menu);
            if (choiceStr == null) break;

            try {
                int choice = Integer.parseInt(choiceStr);

                switch (choice) {
                    case 1 -> {
                        String newEntry = JOptionPane.showInputDialog("Enter a value to add to the front:");
                        if (newEntry != null) {
                            deque.addToFront(newEntry);
                            JOptionPane.showMessageDialog(null, newEntry + " has been added to the front.");
                        }
                    }
                    case 2 -> {
                        String newEntry = JOptionPane.showInputDialog("Enter a value to add to the back:");
                        if (newEntry != null) {
                            deque.addToBack(newEntry);
                            JOptionPane.showMessageDialog(null, newEntry + " has been added to the back.");
                        }
                    }
                    case 3 -> {
                        String frontValue = deque.removeFront();
                        JOptionPane.showMessageDialog(null, "Removed front value: " + frontValue);
                    }
                    case 4 -> {
                        String backValue = deque.removeBack();
                        JOptionPane.showMessageDialog(null, "Removed back value: " + backValue);
                    }
                    case 5 -> {
                        String frontValue = deque.getFront();
                        JOptionPane.showMessageDialog(null, "Front value: " + frontValue);
                    }
                    case 6 -> {
                        String backValue = deque.getBack();
                        JOptionPane.showMessageDialog(null, "Back value: " + backValue);
                    }
                    case 7 -> {
                        boolean isEmpty = deque.isEmpty();
                        JOptionPane.showMessageDialog(null, "Deque is " + (isEmpty ? "empty." : "not empty."));
                    }
                    case 8 -> {
                        deque.clear();
                        JOptionPane.showMessageDialog(null, "Deque has been cleared.");
                    }
                    case 9 -> {
                        deque.printDeque();
                    }
                    case 10 -> {
                        JOptionPane.showMessageDialog(null, "Exiting...");
                        running = false;
                    }
                    default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please select a number between 1 and 10.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (EmptyQueueException e) {
                JOptionPane.showMessageDialog(null, "Error: Deque is empty.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
