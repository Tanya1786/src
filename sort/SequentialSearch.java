public class SequentialSearch {
  public static <T> boolean inArray(T[] anArray, T anEntry)
{
   boolean found = false;
   int index = 0;
   while (!found && (index < anArray.length))
   {
      if (anEntry.equals(anArray[index]))
         found = true;
      index++;
   } // end while

   return found;
} // end inArray

}
