public interface ListInterface2<T> {
    void add(T newEntry);
    void add(int givenPosition, T newEntry);
    T remove(int givenPosition);
    T replace(int givenPosition, T newEntry);
    T getEntry(int givenPosition);
    boolean contains(T anEntry);
    void clear();
    int getLength();
    boolean isEmpty();
    T[] toArray();
    void reverse();
}
