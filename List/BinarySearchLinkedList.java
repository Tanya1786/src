import java.util.LinkedList;
import java.util.Arrays;
public class BinarySearchLinkedList {
  public static <T extends Comparable<? super T>> 
  int binarySearch(LinkedList<T> list, T key) {
      int low = 0;
      int high = list.size() - 1;
      
      while (low <= high) {
          int mid = (low + high) / 2;
          T midVal = list.get(mid);
          int comparison = midVal.compareTo(key);
          
          if (comparison < 0) {
              low = mid + 1;
          } else if (comparison > 0) {
              high = mid - 1;
          } else {
              return mid; // key found
          }
      }
      return -(low + 1);  // key not found
  }

  // Example usage
  public static void main(String[] args) {
      LinkedList<Integer> list = new LinkedList<>(Arrays.asList(11, 12, 22, 25, 34, 64, 90));
      System.out.println("Sorted list: " + list);
      
      int searchKey = 25;
      int result = binarySearch(list, searchKey);
      
      if (result >= 0) {
          System.out.println("Element " + searchKey + " found at index " + result);
      } else {
          System.out.println("Element " + searchKey + " not found");
      }
  }
}