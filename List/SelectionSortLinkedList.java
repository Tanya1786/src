import java.util.LinkedList;
import java.util.Arrays;
public class SelectionSortLinkedList {
  public static <T extends Comparable<? super T>> 
  void selectionSort(LinkedList<T> list) {
      int n = list.size();
      
      for (int i = 0; i < n - 1; i++) {
          int minIndex = i;
          
          // Find minimum element in unsorted portion
          for (int j = i + 1; j < n; j++) {
              if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                  minIndex = j;
              }
          }
          
          // Swap found minimum element with first element of unsorted portion
          if (minIndex != i) {
              T temp = list.get(i);
              list.set(i, list.get(minIndex));
              list.set(minIndex, temp);
          }
      }
  }

  // Example usage
  public static void main(String[] args) {
      LinkedList<Integer> list = new LinkedList<>(Arrays.asList(64, 34, 25, 12, 22, 11, 90));
      System.out.println("Original list: " + list);
      
      selectionSort(list);
      
      System.out.println("Sorted list: " + list);
  }
}