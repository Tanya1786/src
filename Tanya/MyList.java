import java.util.Arrays;
public class MyList<T> implements ListInterface3<T> {
	private T[] list;
    private int size;
    private static final int MAXSIZE = 20;
//constructor
	public MyList() {
		list = (T[]) new Object[MAXSIZE];
		size = 0;
	}
//Adds a new entry to the end of the list.
	@Override
	public void add(T newEntry) {
		if (size < MAXSIZE) {
			list[size] = newEntry;
			size++;
		}
		
	}
    //Adds a new entry to the list at a given position
	@Override
	public void add(int newPosition, T newEntry) {
		if (newPosition >= 0 && newPosition <= size) {
			if (size < MAXSIZE) {
				for (int i = size; i > newPosition; i--) {
					list[i] = list[i - 1];
				}
				list[newPosition] = newEntry;
				size++;
			}
		}
		
	}
	//Removes the entry at a given position from the list.
	
	@Override
	public T remove(int givenPosition) {
		T result = null;
		if (givenPosition >= 0 && givenPosition < size) {
			result = list[givenPosition];
			for (int i = givenPosition; i < size - 1; i++) {
				list[i] = list[i + 1];
			}
			list[size - 1] = null;
			size--;
		}
		return result;
	}
	//Removes all entries from the list.
	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			list[i] = null;
		}
		size = 0;	
	}
	//Replaces the entry at a given position in the list with a given entry.
	@Override
	public void replace(int givenPosition, T newEntry) {
		if (givenPosition >= 0 && givenPosition < size) {
			list[givenPosition] = newEntry;
		}
		
	}
	//Retrieves the entry at a given position in the list
	@Override
	public T getEntry(int givenPosition) {
		T result = null;
		if (givenPosition >= 0 && givenPosition < size) {
			result = list[givenPosition];
		}
		return result;
	}
//Retrieves all entries in the list in their current order.
	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[size];
		for (int i = 0; i < size; i++) {
			result[i] = list[i];
		}
		return result;
	}
//Sees whether the list contains a given entry.
	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		for (int i = 0; i < size; i++) {
			if (list[i].equals(anEntry)) {
				found = true;
				break;
			}
		}
		return found;
	}
//Gets the number of entries in the list
	@Override
	public int getLength() {
		return size;
	}
//Sees whether the list is empty.
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	//Test:
    public static void main(String[] args) {
	 MyList<String> myList = new MyList<>();
     myList.add("Alice");
     myList.add("Connor");
     myList.add("Lyra");
     System.out.println("add(T newEntry): " + Arrays.toString(myList.toArray()));
     myList.add(1, "Sky");
     System.out.println("add(int newPosition, T newEntry): " + Arrays.toString(myList.toArray()));
     myList.remove(2);
     System.out.println("remove(int givenPosition): " + Arrays.toString(myList.toArray()));
     myList.replace(0, "Marshall");
     System.out.println("replace(int givenPosition, T newEntry): " + Arrays.toString(myList.toArray()));
     System.out.println("contains(T anEntry=Lyra): " + myList.contains("Lyra"));
     System.out.println("contains(T anEntry=Tom): " + myList.contains("Tom"));
     System.out.println("getLength(): " + myList.getLength());
     System.out.println("isEmpty(): " + myList.isEmpty());
     myList.clear();
     System.out.println("toArray(): " + Arrays.toString(myList.toArray()));
 }
}
        


