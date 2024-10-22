public class QuickSort {

  private static final int MIN_SIZE = 4; // Minimum size for quicksort before using insertion sort

  public static <T extends Comparable<? super T>> 
  int partition(T[] a, int first, int last) {
      int mid = first + (last - first) / 2;
      sortFirstMiddleLast(a, first, mid, last);

      // Move pivot to next-to-last position
      swap(a, mid, last - 1);
      int pivotIndex = last - 1;
      T pivotValue = a[pivotIndex];

      // Determine subarrays Smaller and Larger
      int indexFromLeft = first + 1;
      int indexFromRight = last - 2;
      boolean done = false;

      while (!done) {
          // Find first entry on left that is >= pivotValue
          while (a[indexFromLeft].compareTo(pivotValue) < 0) {
              indexFromLeft++;
          }

          // Find first entry on right that is <= pivotValue
          while (a[indexFromRight].compareTo(pivotValue) > 0) {
              indexFromRight--;
          }

          if (indexFromLeft < indexFromRight) {
              swap(a, indexFromLeft, indexFromRight);
              indexFromLeft++;
              indexFromRight--;
          } else {
              done = true;
          }
      }

      // Place pivotValue between Smaller and Larger subarrays
      swap(a, pivotIndex, indexFromLeft);
      pivotIndex = indexFromLeft;

      return pivotIndex;
  }

  public static <T extends Comparable<? super T>>
  void quickSort(T[] a, int first, int last) {
      if (last - first + 1 < MIN_SIZE) {
          insertionSort(a, first, last);
      } else {
          // Create the partition: Smaller | Pivot | Larger
          int pivotIndex = partition(a, first, last);

          // Sort subarrays Smaller and Larger
          quickSort(a, first, pivotIndex - 1);
          quickSort(a, pivotIndex + 1, last);
      }
  }

  // Helper methods

  private static <T extends Comparable<? super T>>
  void sortFirstMiddleLast(T[] a, int first, int mid, int last) {
      if (a[first].compareTo(a[mid]) > 0) {
          swap(a, first, mid);
      }
      if (a[mid].compareTo(a[last]) > 0) {
          swap(a, mid, last);
      }
      if (a[first].compareTo(a[mid]) > 0) {
          swap(a, first, mid);
      }
  }

  private static <T> void swap(T[] a, int i, int j) {
      T temp = a[i];
      a[i] = a[j];
      a[j] = temp;
  }

  private static <T extends Comparable<? super T>>
  void insertionSort(T[] a, int first, int last) {
      for (int unsorted = first + 1; unsorted <= last; unsorted++) {
          T nextToInsert = a[unsorted];
          int index = unsorted;
          while ((index > first) && (nextToInsert.compareTo(a[index - 1]) < 0)) {
              a[index] = a[index - 1];
              index--;
          }
          a[index] = nextToInsert;
      }
  }

  // Example usage
  public static void main(String[] args) {
      Integer[] arr = {64, 34, 25, 12, 22, 11, 90};
      System.out.println("Original array: " + java.util.Arrays.toString(arr));
      
      quickSort(arr, 0, arr.length - 1);
      
      System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
  }
}