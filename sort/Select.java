public class Select{
  // Recursive selection sort method
  public static void selectionSort(int[] a, int first, int last) {
      // Base case: If the array has only one element, it is already sorted
      if (first < last) {
          // Find the index of the smallest element in the subarray from 'first' to 'last'
          int indexOfNextSmallest = findIndexOfSmallest(a, first, last);

          // Swap the smallest element with the element at 'first'
          swap(a, first, indexOfNextSmallest);

          // Recursively sort the remaining array from 'first + 1' to 'last'
          selectionSort(a, first + 1, last);
      }
  }

  // Helper method to find the index of the smallest element in a subarray
  private static int findIndexOfSmallest(int[] a, int first, int last) {
      int minIndex = first; // Assume the first element is the smallest
      for (int i = first + 1; i <= last; i++) {
          if (a[i] < a[minIndex]) {
              minIndex = i; // Update minIndex if a smaller element is found
          }
      }
      return minIndex;
  }

  // Helper method to swap two elements in an array
  private static void swap(int[] a, int i, int j) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
  }

  // Main method for testing
  public static void main(String[] args) {
      int[] array = {64, 25, 12, 22, 11};

      System.out.println("Original Array:");
      printArray(array);

      // Perform selection sort
      selectionSort(array, 0, array.length - 1);

      System.out.println("\nSorted Array:");
      printArray(array);
  }

  // Method to print array
  public static void printArray(int[] array) {
      for (int value : array) {
          System.out.print(value + " ");
      }
      System.out.println();
  }
}
