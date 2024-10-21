import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class StaffManagement {
    private ArrayList<Staff> staffList = new ArrayList<>();

    public static void main(String[] args) {
        StaffManagement sm = new StaffManagement();
        sm.generateStaff(10); // Change N here for more staff
        sm.menu();
    }

    private void generateStaff(int N) {
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            String name = "Staff" + (i + 1);
            int age = rand.nextInt(40) + 20; // Age between 20 and 59
            staffList.add(new Staff(name, age));
        }
    }

    private void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Sort in ascending order");
            System.out.println("2. Sort in descending order");
            System.out.println("3. Find a person");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    Collections.sort(staffList);
                    displayStaff();
                    break;
                case 2:
                    Collections.sort(staffList, Collections.reverseOrder());
                    displayStaff();
                    break;
                case 3:
                    System.out.print("Enter name to search: ");
                    String name = scanner.nextLine();
                    int index = linearSearch(name);
                    if (index == -1) {
                        System.out.println("Name not found.");
                    } else {
                        System.out.println("Found at index: " + index);
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    private int linearSearch(String name) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).name.equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    private void displayStaff() {
        System.out.println("Staff List:");
        for (Staff staff : staffList) {
            System.out.println(staff);
        }
    }
}
