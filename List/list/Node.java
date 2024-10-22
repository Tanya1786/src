public class Node<T> {
  private T data;
  private Node<T> next;

  public Node(T dataPart) {
      data = dataPart;
      next = null;
  }

  public Node(T dataPart, Node<T> nextNode) {
      data = dataPart;
      next = nextNode;
  }

  public T getData() {
      return data;
  }

  public void setData(T newData) {
      data = newData;
  }

  public Node<T> getNextNode() {
      return next;
  }

  public void setNextNode(Node<T> nextNode) {
      next = nextNode;
  }
}
