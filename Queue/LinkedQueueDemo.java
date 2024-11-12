package cheatsheet.Queue;

import javax.swing.JOptionPane;

public class LinkedQueueDemo {
    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<>();
        boolean running = true;

        while (running) {
            String menu = """
                    Choose an operation:
                    1. Enqueue
                    2. Dequeue
                    3. Get Front
                    4. Is Empty
                    5. Clear
                    6. Print Queue
                    7. Exit
                    """;

            String choiceStr = JOptionPane.showInputDialog(menu);
            if (choiceStr == null) break;

            try {
                int choice = Integer.parseInt(choiceStr);

                switch (choice) {
                    case 1 -> {
                        String newEntry = JOptionPane.showInputDialog("Enter a value to enqueue:");
                        if (newEntry != null) {
                            queue.enqueue(newEntry);
                            JOptionPane.showMessageDialog(null, newEntry + " has been enqueued.");
                        }
                    }
                    case 2 -> {
                        String dequeuedValue = queue.dequeue();
                        JOptionPane.showMessageDialog(null, "Dequeued value: " + dequeuedValue);
                    }
                    case 3 -> {
                        String frontValue = queue.getFront();
                        JOptionPane.showMessageDialog(null, "Front value: " + frontValue);
                    }
                    case 4 -> {
                        boolean isEmpty = queue.isEmpty();
                        JOptionPane.showMessageDialog(null, "Queue is " + (isEmpty ? "empty." : "not empty."));
                    }
                    case 5 -> {
                        queue.clear();
                        JOptionPane.showMessageDialog(null, "Queue has been cleared.");
                    }
                    case 6 -> {
                        queue.printQueue();
                    }
                    case 7 -> {
                        JOptionPane.showMessageDialog(null, "Exiting...");
                        running = false;
                    }
                    default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please select a number between 1 and 7.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (EmptyQueueException e) {
                JOptionPane.showMessageDialog(null, "Error: Queue is empty.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
