public class ListDemo2 {
    public static void main(String[] args) {
        // Create an instance of LList (Linked List)
        ListInterface2<String> myList = new LList<>();

        // Display whether the list is empty
        System.out.println("Is the list empty? " + myList.isEmpty());

        // Add elements to the list
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");
        myList.add("Date");

        // Display the contents of the list
        System.out.println("Contents of the list after adding 4 items:");
        displayList(myList);

        // Add an element at a specific position
        myList.add(2, "Mango");
        System.out.println("Contents of the list after adding 'Mango' at position 2:");
        displayList(myList);

        // Replace an element at a given position
        myList.replace(3, "Orange");
        System.out.println("Contents of the list after replacing position 3 with 'Orange':");
        displayList(myList);

        // Remove an element at a given position
        myList.remove(4);
        System.out.println("Contents of the list after removing the element at position 4:");
        displayList(myList);

        // Check if the list contains a specific element
        System.out.println("Does the list contain 'Banana'? " + myList.contains("Banana"));
        System.out.println("Does the list contain 'Grapes'? " + myList.contains("Grapes"));

        // Get an entry at a specific position
        System.out.println("Entry at position 2: " + myList.getEntry(2));

        // Display the length of the list
        System.out.println("Current length of the list: " + myList.getLength());

        // Reverse the list
        myList.reverse();
        System.out.println("Contents of the list after reversing:");
        displayList(myList);

        // Clear the list
        myList.clear();
        System.out.println("After clearing, is the list empty? " + myList.isEmpty());
    }

    // Helper method to display the list contents
    private static void displayList(ListInterface2<String> list) {
        Object[] array = list.toArray();
        System.out.print("The list contains: ");
        for (Object element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
