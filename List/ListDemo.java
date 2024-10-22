public class ListDemo {
  public static void main(String[] args) {
      ListADT<String> list = new LinkedList<>();
      list.add("Alice");
      list.add("Bob");
      list.add("Charlie");

      System.out.println("Size of list: " + list.size());
      System.out.println("Element at index 1: " + list.get(1));

      list.remove("Bob");
      System.out.println("Size of list after removal: " + list.size());
      System.out.println("Element at index 1 after removal: " + list.get(1));
  }
}
