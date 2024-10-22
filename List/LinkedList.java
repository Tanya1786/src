public class LinkedList<T> implements ListADT<T> {
  private Node<T> head;
  private int size;

  public LinkedList() {
      this.head = null;
      this.size = 0;
  }

  @Override
  public void add(T item) {
      Node<T> newNode = new Node<>(item);
      if (head == null) {
          head = newNode;
      } else {
          Node<T> current = head;
          while (current.next != null) {
              current = current.next;
          }
          current.next = newNode;
      }
      size++;
  }

  @Override
  public void remove(T item) {
      if (head == null) return;

      if (head.data.equals(item)) {
          head = head.next;
          size--;
          return;
      }

      Node<T> current = head;
      while (current.next != null) {
          if (current.next.data.equals(item)) {
              current.next = current.next.next;
              size--;
              return;
          }
          current = current.next;
      }
  }

  @Override
  public T get(int index) {
      if (index < 0 || index >= size) {
          throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      }
      Node<T> current = head;
      for (int i = 0; i < index; i++) {
          current = current.next;
      }
      return current.data;
  }

  @Override
  public int size() {
      return size;
  }

  @Override
  public boolean isEmpty() {
      return size == 0;
  }
}
