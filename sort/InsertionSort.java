 /** A class of static, iterative methods for sorting an array of
Comparable objects from smallest to largest.  */
public class InsertionSort
{
/** Sorts the first n objects in an array into ascending order using insertion sort.
    @param a  An array of Comparable objects.
    @param first  The starting index of the portion to sort.
    @param last   The ending index of the portion to sort. */
public static <T extends Comparable<? super T>>
       void insertionSort(T[] a, int first, int last)
{
   if (first < last)
   {
      // Sort all but the last entry
      insertionSort(a, first, last - 1);

      // Insert the last entry in sorted order
      insertInOrder(a[last], a, first, last - 1); 
   } // end if
} // end insertionSort

/** Inserts an entry into a sorted portion of an array.
    @param entry  The entry to be inserted.
    @param a      An array of Comparable objects.
    @param first  The starting index of the sorted portion.
    @param last   The ending index of the sorted portion. */
private static <T extends Comparable<? super T>>
       void insertInOrder(T entry, T[] a, int first, int last)
{
   int index = last;

   // Shift elements to the right to make room for the entry
   while (index >= first && a[index].compareTo(entry) > 0)
   {
      a[index + 1] = a[index]; // Shift right
      index--;
   }

   // Insert the entry in the correct position
   a[index + 1] = entry;
} // end insertInOrder
} // end SortArray

  

