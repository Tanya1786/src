import java.util.LinkedList;
import java.util.Arrays;
public class InsertionSortLinkedList {
  public static <T extends Comparable<? super T>> 
  void insertionSort(LinkedList<T> list) {
      int n = list.size();
      
      for (int i = 1; i < n; i++) {
          T key = list.get(i);
          int j = i - 1;
          
          // Move elements that are greater than key to one position ahead
          while (j >= 0 && list.get(j).compareTo(key) > 0) {
              list.set(j + 1, list.get(j));
              j--;
          }
          list.set(j + 1, key);
      }
  }

  // Example usage
  public static void main(String[] args) {
      LinkedList<Integer> list = new LinkedList<>(Arrays.asList(64, 34, 25, 12, 22, 11, 90));
      System.out.println("Original list: " + list);
      
      insertionSort(list);
      
      System.out.println("Sorted list: " + list);
  }
}