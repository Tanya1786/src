import java.util.LinkedList;
import java.util.Arrays;
public class ShellSortLinkedList {
  public static <T extends Comparable<? super T>> 
  void shellSort(LinkedList<T> list) {
      int n = list.size();
      
      // Start with a big gap, then reduce the gap
      for (int gap = n/2; gap > 0; gap /= 2) {
          // Do a gapped insertion sort
          for (int i = gap; i < n; i++) {
              T temp = list.get(i);
              int j;
              
              // Shift earlier gap-sorted elements up until the correct location for temp is found
              for (j = i; j >= gap && list.get(j - gap).compareTo(temp) > 0; j -= gap) {
                  list.set(j, list.get(j - gap));
              }
              
              list.set(j, temp);
          }
      }
  }

  // Example usage
  public static void main(String[] args) {
      LinkedList<Integer> list = new LinkedList<>(Arrays.asList(64, 34, 25, 12, 22, 11, 90));
      System.out.println("Original list: " + list);
      
      shellSort(list);
      
      System.out.println("Sorted list: " + list);
  }
}