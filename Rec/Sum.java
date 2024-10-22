public static int SumArray(int[] array, int start) {
  if (start >= array.length) {
      return 0;  // Base case: if the start index goes beyond the array length
  }
  return array[start] + SumArray(array, start + 1);  // Recursive case: add current element and move to the next
}


public static int SumList(List<Integer> list, int start) {
  if (start >= list.size()) {
      return 0;  // Base case: beyond the list size
  }
  return list.get(start) + SumList(list, start + 1);  // Recursive case: add current element and move to the next
}
class Node {
  int data;
  Node next;
  public Node(int data) {
      this.data = data;
      this.next = null;
  }
}
public static int SumLinkedList(Node head) {
  if (head == null) {
      return 0;  // Base case: when the list is empty or no more nodes
  }
  return head.data + SumLinkedList(head.next);  // Recursive case: sum current node and recurse for next node
}

