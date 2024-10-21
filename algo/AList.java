import java.util.Arrays;

public class AList<T> implements ListInterface<T> {
    private T[] list;   // Array of list entries; ignore list[0]
    private int numberOfEntries;
    private boolean integrityOK;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public AList() {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    public AList(int initialCapacity) {
        integrityOK = false;

        // Is initialCapacity too small?
        if (initialCapacity < DEFAULT_CAPACITY)
            initialCapacity = DEFAULT_CAPACITY;
        else // Is initialCapacity too big?
            checkCapacity(initialCapacity);

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempList = (T[]) new Object[initialCapacity + 1];
        list = tempList;
        numberOfEntries = 0;
        integrityOK = true;
    } // end constructor

    public void add(T newEntry) {
        checkIntegrity();
        list[numberOfEntries + 1] = newEntry;
        numberOfEntries++;
        ensureCapacity();
    } // end add

    public void add(int newPosition, T newEntry) {
        checkIntegrity();
        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            if (newPosition <= numberOfEntries)
                makeRoom(newPosition);
            list[newPosition] = newEntry;
            numberOfEntries++;
            ensureCapacity(); // Ensure enough room for next add
        } else {
            throw new IndexOutOfBoundsException(
                    "Given position of add's new entry is out of bounds.");
        }
    } // end add

    public T remove(int givenPosition) {
        checkIntegrity();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            // Assertion: The list is not empty
            T result = list[givenPosition]; // Get entry to be removed
            // Move subsequent entries towards entry to be removed,
            // unless it is last in list
            if (givenPosition < numberOfEntries)
                removeGap(givenPosition);
            list[numberOfEntries] = null;
            numberOfEntries--;
            return result; // Return reference to removed entry
        } else {
            throw new IndexOutOfBoundsException(
                    "Illegal position given to remove operation.");
        }
    } // end remove

    public void clear() {
        checkIntegrity();
        for (int index = 1; index <= numberOfEntries; index++) {
            list[index] = null; // Remove references to entries
        }
        numberOfEntries = 0;
    } // end clear

    public T replace(int givenPosition, T newEntry) {
        checkIntegrity();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            T oldEntry = list[givenPosition];
            list[givenPosition] = newEntry;
            return oldEntry; // Return the replaced entry
        } else {
            throw new IndexOutOfBoundsException(
                    "Illegal position given to replace operation.");
        }
    } // end replace

    public T getEntry(int givenPosition) {
        checkIntegrity();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            return list[givenPosition]; // Return entry at the position
        } else {
            throw new IndexOutOfBoundsException(
                    "Illegal position given to getEntry operation.");
        }
    } // end getEntry

    public boolean contains(T anEntry) {
        checkIntegrity();
        boolean found = false;
        int index = 1;
        while (!found && (index <= numberOfEntries)) {
            if (anEntry.equals(list[index]))
                found = true;
            index++;
        } // end while
        return found;
    } // end contains

    public int getLength() {
        return numberOfEntries;
    } // end getLength

    public boolean isEmpty() {
        return numberOfEntries == 0; // Or getLength() == 0
    } // end isEmpty

    public T[] toArray() {
        checkIntegrity();

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = list[index + 1];
        } // end for

        return result;
    } // end toArray

    // Throws an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a list whose capacity exceeds " +
                    "allowed maximum of " + MAX_CAPACITY);
    } // end checkCapacity

    // Throws an exception if receiving object is not initialized.
    private void checkIntegrity() {
        if (!integrityOK)
            throw new SecurityException("Array object is corrupt.");
    } // end checkIntegrity

    // Doubles the capacity of the array list if it is full.
    // Precondition: checkIntegrity has been called.
    private void ensureCapacity() {
        int capacity = list.length - 1;
        if (numberOfEntries >= capacity) {
            int newCapacity = 2 * capacity;
            checkCapacity(newCapacity); // Is capacity too big?
            list = Arrays.copyOf(list, newCapacity + 1);
        } // end if
    } // end ensureCapacity

    // Shifts entries that are beyond the entry to be removed to the next lower position.
    // Precondition: 1 <= givenPosition < numberOfEntries;
    //               numberOfEntries is list's length before removal;
    //               checkIntegrity has been called.
    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition;
        for (int index = removedIndex; index < numberOfEntries; index++)
            list[index] = list[index + 1];
    } // end removeGap

    // Makes room for a new entry by shifting entries down.
    private void makeRoom(int givenPosition) {
        int newIndex = givenPosition;
        int lastIndex = numberOfEntries;
        for (int index = lastIndex; index >= newIndex; index--)
            list[index + 1] = list[index];
    } // end makeRoom
} // end AList
