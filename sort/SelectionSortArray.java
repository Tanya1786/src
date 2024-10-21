/** A class of static, iterative methods for sorting an array of
   Comparable objects from smallest to largest.  */
   public class SelectionSortArray
   {
      /** Sorts the first n objects in an array into ascending order.
          @param a  An array of Comparable objects.
          @param n  An integer > 0. */
      public static <T extends Comparable<? super T>>
             void selectionSort(T[] a, int n)
      {
         for (int index = 0; index < n - 1; index++)
         {
            int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);
            swap(a, index, indexOfNextSmallest);
            // Assertion: a[0] <= a[1] <= ... <= a[index] <= all other a[i]
         } // end for
      } // end selectionSort
   
      /** Gets the index of the smallest value in a portion of an array.
          @param a  An array of Comparable objects.
          @param fromIndex  The starting index of the portion to search.
          @param toIndex    The ending index of the portion to search.
          @return The index of the smallest value. */
      private static <T extends Comparable<? super T>>
             int getIndexOfSmallest(T[] a, int fromIndex, int toIndex)
      {
         T min = a[fromIndex];
         int indexOfMin = fromIndex;
   
         for (int index = fromIndex + 1; index <= toIndex; index++)
         {
            if (a[index].compareTo(min) < 0)
            {
               min = a[index];
               indexOfMin = index;
            }
         }
   
         return indexOfMin;
      } // end getIndexOfSmallest
   
      /** Swaps two elements in an array.
          @param a  An array of Comparable objects.
          @param i  The index of the first element to swap.
          @param j  The index of the second element to swap. */
      private static <T> void swap(T[] a, int i, int j)
      {
         T temp = a[i];
         a[i] = a[j];
         a[j] = temp;
      } // end swap
   } // end SortArray
   