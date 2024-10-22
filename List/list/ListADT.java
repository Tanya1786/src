public interface ListADT<T> {
    void add(T item);
    void remove(T item);
    T get(int index);
    int size();
    boolean isEmpty();
}
