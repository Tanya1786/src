import java.util.Arrays;

public class LList<T> implements ListInterface2<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length;

    public LList() {
        initFields();
    }

    private void initFields() {
        head = null;
        tail = null;
        length = 0;
    }

    @Override
    public void add(T newEntry) {
        Node<T> newNode = new Node<>(newEntry);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNextNode(newNode);
        }
        tail = newNode;
        length++;
    }

    @Override
    public void add(int givenPosition, T newEntry) {
        if ((givenPosition >= 1) && (givenPosition <= length + 1)) {
            Node<T> newNode = new Node<>(newEntry);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else if (givenPosition == 1) {
                newNode.setNextNode(head);
                head = newNode;
            } else if (givenPosition == length + 1) {
                tail.setNextNode(newNode);
                tail = newNode;
            } else {
                Node<T> nodeBefore = getNodeAt(givenPosition - 1);
                Node<T> nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);
            }
            length++;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to add operation.");
        }
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;
        if ((givenPosition >= 1) && (givenPosition <= length)) {
            if (givenPosition == 1) {
                result = head.getData();
                head = head.getNextNode();
                if (length == 1) {
                    tail = null;
                }
            } else {
                Node<T> nodeBefore = getNodeAt(givenPosition - 1);
                Node<T> nodeToRemove = nodeBefore.getNextNode();
                Node<T> nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter);
                result = nodeToRemove.getData();
                if (givenPosition == length) {
                    tail = nodeBefore;
                }
            }
            length--;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
        }
        return result;
    }

    @Override
    public T replace(int givenPosition, T newEntry) {
        if ((givenPosition >= 1) && (givenPosition <= length)) {
            Node<T> desiredNode = getNodeAt(givenPosition);
            T originalEntry = desiredNode.getData();
            desiredNode.setData(newEntry);
            return originalEntry;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
        }
    }

    @Override
    public T getEntry(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= length)) {
            return getNodeAt(givenPosition).getData();
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
        }
    }

    private Node<T> getNodeAt(int givenPosition) {
        Node<T> currentNode = head;
        for (int counter = 1; counter < givenPosition; counter++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node<T> currentNode = head;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData())) {
                found = true;
            } else {
                currentNode = currentNode.getNextNode();
            }
        }
        return found;
    }

    @Override
    public void clear() {
        initFields();
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] result = (T[]) new Object[length];
        int index = 0;
        Node<T> currentNode = head;
        while ((index < length) && (currentNode != null)) {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        }
        return result;
    }

    @Override
    public int getLength() {
        return length;
    }

    public void printList() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNextNode();
        }
        System.out.println();
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;
        tail = head; // New tail will be the old head

        while (current != null) {
            next = current.getNextNode();
            current.setNextNode(prev);
            prev = current;
            current = next;
        }
        head = prev; // New head will be the old tail
    }
}
