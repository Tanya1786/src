public static int LargestInArray(int[] array, int n) {
  if (n == 1) {
      return array[0];  // Base case: only one element left to compare
  }
  return Math.max(array[n - 1], LargestInArray(array, n - 1));  // Recursive case: compare last element with the largest in the rest
}


public static int LargestInList(List<Integer> list, int n) {
  if (n == 1) {
      return list.get(0);  // Base case: one element left
  }
  return Math.max(list.get(n - 1), LargestInList(list, n - 1));  // Compare last element with the largest in the rest
}


class Node {
  int data;
  Node next;
  public Node(int data) {
      this.data = data;
      this.next = null;
  }
}
public static int LargestInLinkedList(Node head) {
  if (head.next == null) {
      return head.data;  // Base case: last node, return its value
  }
  return Math.max(head.data, LargestInLinkedList(head.next));  // Recursive case: compare current node with the largest in the rest
}
