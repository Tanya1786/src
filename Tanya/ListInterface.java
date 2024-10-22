
public interface ListInterface3<T> {
 //method add(newEntry): adds a new entry to the end of the list.
	    public void add(T newEntry);
//method add(newPosition, newEntry): Adds a new entry to the list at a given position.
	    public void add(int newPosition, T newEntry);
//method remove(givenPosition): Removes the entry at a given position from the list.
	    public T remove(int givenPosition);
//method clear(): Removes all entries from the list.
	    public void clear();
//method replace(givenPosition, newEntry): Replaces the entry at a given position in the list with a given entry.
	    public void replace(int givenPosition, T newEntry);
//method getEntry(givenPosition): Retrieves the entry at a given position in the list.
	    public T getEntry(int givenPosition);
//method toArray(): Retrieves all entries in the list in their current order.
	    public T[] toArray();
//method contains(anEntry): Sees whether the list contains a given entry.
	    public boolean contains(T anEntry);
//method getLength(): Gets the number of entries in the list.
	    public int getLength();
//method isEmpty(): Sees whether the list is empty.
	    public boolean isEmpty();
}
