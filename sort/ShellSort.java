public class ShellSort {

  public static void shellSort(int[] a, int first, int last) {
      // Sorts the array entries a[first] through a[last] into ascending order.
      // first >= 0 and < a.length; last >= first and < a.length.
      int n = last - first + 1; // number of array entries
      int space = n / 2;

      while (space > 0) {
          for (int begin = first; begin < first + space; begin++) {
              incrementalInsertionSort(a, begin, last, space);
          }
          space = space / 2;
      }
  }

  private static void incrementalInsertionSort(int[] a, int first, int last, int space) {
      // Sorts equally spaced array entries a[first] through a[last] into ascending order.
      // first >= 0 and < a.length; last >= first and < a.length;
      // space is the difference between the indices of the entries to sort.
      for (int unsorted = first + space; unsorted <= last; unsorted += space) {
          int nextToInsert = a[unsorted];
          int index = unsorted - space;

          while ((index >= first) && (nextToInsert < a[index])) {
              a[index + space] = a[index];
              index = index - space;
          }
          a[index + space] = nextToInsert;
      }
  }

  // Example usage
  public static void main(String[] args) {
      int[] arr = {64, 34, 25, 12, 22, 11, 90};
      System.out.println("Original array: " + java.util.Arrays.toString(arr));
      
      shellSort(arr, 0, arr.length - 1);
      
      System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
  }
}