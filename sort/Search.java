private static <T> boolean search(T[] anArray, int first, int last, T desiredItem)
{
   boolean found;
   if (first > last)
      found = false; // No elements to search
   else if (desiredItem.equals(anArray[first]))
      found = true;
   else
      found = search(anArray, first + 1, last, desiredItem);
      
   return found;
} // end search

//Binary Search of a Sorted Array
public static <T extends Comparable<T>> boolean binarySearch(T[] a, int first, int last, T desiredItem) {
  // Calculate the midpoint
  int mid = (first + last) / 2;
  
  // Base case: if the range is invalid, the item is not present
  if (first > last) {
      return false;
  }
  
  // Check if the item at the midpoint is the desired item
  if (desiredItem.equals(a[mid])) {
      return true;
  }
  // If the desired item is smaller than the midpoint, search the left half
  else if (desiredItem.compareTo(a[mid]) < 0) {
      return binarySearch(a, first, mid - 1, desiredItem);
  }
  // If the desired item is larger than the midpoint, search the right half
  else {
      return binarySearch(a, mid + 1, last, desiredItem);
  }
}
