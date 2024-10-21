import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueInsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            Queue<Character> queue = new LinkedList<>();

            for (int i = name.length() - 1; i >= 0; i--) {
                char ch = name.charAt(i);
                if (Character.isLetter(ch)) {
                    queue.add(ch);
                }
            }

            ArrayList<Character> arrayList = new ArrayList<>();
            while (!queue.isEmpty()) {
                char letter = queue.poll();
                insertInOrder(arrayList, letter);
                System.out.println("Current ArrayList: " + arrayList);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void insertInOrder(ArrayList<Character> list, char letter) {
        int i = 0;
        while (i < list.size() && list.get(i) < letter) {
            i++;
        }
        list.add(i, letter);
    }
}
