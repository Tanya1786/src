public void displayArrayBackwards(int[] array, int start, int end) {
  if (end < start) {
      return;  // Base case: when end index is less than start, stop recursion
  }
  System.out.print(array[end] + " ");  // Print current element
  displayArrayBackwards(array, start, end - 1);  // Recursive call for the next element backwards
}


public void displayListBackwards(List<Integer> list, int start, int end) {
  if (end < start) {
      return;  // Base case: stop when end is less than start
  }
  System.out.print(list.get(end) + " ");  // Print current element
  displayListBackwards(list, start, end - 1);  // Recursive call for the next element backwards
}




class Node {
  int data;
  Node next;
  public Node(int data) {
      this.data = data;
      this.next = null;
  }
}
public void displayLinkedListBackwards(Node head) {
  if (head == null) {
      return;  // Base case: reached end of the list
  }
  displayLinkedListBackwards(head.next);  // Recursive call to reach the last node
  System.out.print(head.data + " ");  // Print after returning from recursion (backtracking)
}
