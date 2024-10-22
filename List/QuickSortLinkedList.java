import java.util.LinkedList;
import java.util.Arrays;
public class QuickSortLinkedList {
  public static <T extends Comparable<? super T>> 
  void quickSort(LinkedList<T> list) {
      quickSort(list, 0, list.size() - 1);
  }
  
  private static <T extends Comparable<? super T>> 
  void quickSort(LinkedList<T> list, int low, int high) {
      if (low < high) {
          int pivotIndex = partition(list, low, high);
          quickSort(list, low, pivotIndex - 1);
          quickSort(list, pivotIndex + 1, high);
      }
  }
  
  private static <T extends Comparable<? super T>> 
  int partition(LinkedList<T> list, int low, int high) {
      T pivot = list.get(high);
      int i = low - 1;
      
      for (int j = low; j < high; j++) {
          if (list.get(j).compareTo(pivot) <= 0) {
              i++;
              // Swap
              T temp = list.get(i);
              list.set(i, list.get(j));
              list.set(j, temp);
          }
      }
      
      // Place pivot in correct position
      T temp = list.get(i + 1);
      list.set(i + 1, list.get(high));
      list.set(high, temp);
      
      return i + 1;
  }

  // Example usage
  public static void main(String[] args) {
      LinkedList<Integer> list = new LinkedList<>(Arrays.asList(64, 34, 25, 12, 22, 11, 90));
      System.out.println("Original list: " + list);
      
      quickSort(list);
      
      System.out.println("Sorted list: " + list);
  }
}