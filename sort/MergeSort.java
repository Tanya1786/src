/** A class of static, iterative methods for sorting an array of
   Comparable objects from smallest to largest.  */
   public class MergeSort
   {
      /** Sorts the array using merge sort.
          @param a  An array of Comparable objects.
          @param first  The starting index of the portion to sort.
          @param last   The ending index of the portion to sort. */
      public static <T extends Comparable<? super T>>
             void mergeSort(T[] a, int first, int last)
      {
         // The cast is safe because the new array contains null entries
         @SuppressWarnings("unchecked")
         T[] tempArray = (T[]) new Comparable<?>[a.length]; // Unchecked cast
         mergeSort(a, tempArray, first, last);
      } // end mergeSort
   
      /** Helper method for performing merge sort.
          @param a          An array of Comparable objects.
          @param tempArray  A temporary array for merging.
          @param first      The starting index of the portion to sort.
          @param last       The ending index of the portion to sort. */
      private static <T extends Comparable<? super T>>
             void mergeSort(T[] a, T[] tempArray, int first, int last)
      {
         if (first < last)
         {
            int mid = (first + last) / 2;
   
            // Sort the left half
            mergeSort(a, tempArray, first, mid);
            // Sort the right half
            mergeSort(a, tempArray, mid + 1, last);
            // Merge the sorted halves
            merge(a, tempArray, first, mid, last);
         } // end if
      } // end mergeSort
   
      /** Merges two sorted subarrays.
          @param a          An array of Comparable objects.
          @param tempArray  A temporary array for merging.
          @param first      The starting index of the first subarray.
          @param mid        The ending index of the first subarray.
          @param last       The ending index of the second subarray. */
      private static <T extends Comparable<? super T>>
             void merge(T[] a, T[] tempArray, int first, int mid, int last)
      {
         int beginHalf1 = first;
         int endHalf1 = mid;
         int beginHalf2 = mid + 1;
         int endHalf2 = last;
   
         int index = 0; // Next available location in tempArray
   
         // While both subarrays are not empty, compare and merge
         while (beginHalf1 <= endHalf1 && beginHalf2 <= endHalf2)
         {
            if (a[beginHalf1].compareTo(a[beginHalf2]) <= 0)
            {
               tempArray[index] = a[beginHalf1];
               beginHalf1++;
            }
            else
            {
               tempArray[index] = a[beginHalf2];
               beginHalf2++;
            }
            index++;
         }
   
         // Copy remaining entries from the first half, if any
         while (beginHalf1 <= endHalf1)
         {
            tempArray[index] = a[beginHalf1];
            beginHalf1++;
            index++;
         }
   
         // Copy remaining entries from the second half, if any
         while (beginHalf2 <= endHalf2)
         {
            tempArray[index] = a[beginHalf2];
            beginHalf2++;
            index++;
         }
   
         // Copy the sorted entries back to the original array
         for (int i = 0; i < index; i++)
         {
            a[first + i] = tempArray[i];
         }
      } // end merge
   } // end SortArray
   