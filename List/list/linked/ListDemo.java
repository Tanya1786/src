public class ListDemo {
  public static void main(String[] args) {
      ListInterface<String> myList = new LinkedList<>();

      // Adding elements to the list
      myList.add("Apple");
      myList.add("Banana");
      myList.add("Cherry");

      // Add at a specific position
      myList.add(2, "Mango");

      // Display list as array
      System.out.println("List content: " + java.util.Arrays.toString(myList.toArray()));

      // Remove an item
      myList.remove(3);
      System.out.println("After removing item at position 3: " + java.util.Arrays.toString(myList.toArray()));

      // Replace an item
      myList.replace(2, "Orange");
      System.out.println("After replacing item at position 2: " + java.util.Arrays.toString(myList.toArray()));

      // Check if list contains a certain item
      System.out.println("List contains 'Apple': " + myList.contains("Apple"));
      System.out.println("List contains 'Banana': " + myList.contains("Banana"));

      // Get an entry at a given position
      System.out.println("Entry at position 2: " + myList.getEntry(2));

      // Get length of the list
      System.out.println("List length: " + myList.getLength());

      // Check if the list is empty
      System.out.println("Is the list empty? " + myList.isEmpty());

      // Clear the list
      myList.clear();
      System.out.println("After clearing the list, is it empty? " + myList.isEmpty());
  }
}
