public interface ListInterface<T> {
  void add(T newEntry);
  void add(int givenPosition, T newEntry);
  T[] toArray();
  T remove(int givenPosition);
  boolean replace(int givenPosition, T newEntry);
  T getEntry(int givenPosition);
  boolean contains(T anEntry);
  void clear();
  int getLength();
  boolean isEmpty();
}