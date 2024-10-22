import java.util.LinkedList;
import java.util.Arrays;
public class MergeSortLinkedList {
  public static <T extends Comparable<? super T>> 
  void mergeSort(LinkedList<T> list) {
      if (list.size() <= 1) {
          return;
      }
      
      int mid = list.size() / 2;
      LinkedList<T> left = new LinkedList<>(list.subList(0, mid));
      LinkedList<T> right = new LinkedList<>(list.subList(mid, list.size()));
      
      mergeSort(left);
      mergeSort(right);
      
      merge(list, left, right);
  }
  
  private static <T extends Comparable<? super T>> 
  void merge(LinkedList<T> result, LinkedList<T> left, LinkedList<T> right) {
      result.clear();
      int leftIndex = 0, rightIndex = 0;
      
      while (leftIndex < left.size() && rightIndex < right.size()) {
          if (left.get(leftIndex).compareTo(right.get(rightIndex)) <= 0) {
              result.add(left.get(leftIndex++));
          } else {
              result.add(right.get(rightIndex++));
          }
      }
      
      // Add remaining elements
      while (leftIndex < left.size()) {
          result.add(left.get(leftIndex++));
      }
      while (rightIndex < right.size()) {
          result.add(right.get(rightIndex++));
      }
  }

  // Example usage
  public static void main(String[] args) {
      LinkedList<Integer> list = new LinkedList<>(Arrays.asList(64, 34, 25, 12, 22, 11, 90));
      System.out.println("Original list: " + list);
      
      mergeSort(list);
      
      System.out.println("Sorted list: " + list);
  }
}