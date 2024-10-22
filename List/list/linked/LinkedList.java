import java.util.Arrays;

public class LinkedList<T> implements listinterface<T> {
    
    private Node firstNode;
    private int numberOfEntries;

    public LinkedList() {
        firstNode = null;
        numberOfEntries = 0;
    }

    private class Node {
        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.next = newNode;
        }
        numberOfEntries++;
    }

    @Override
    public void add(int givenPosition, T newEntry) {
        if (givenPosition >= 1 && givenPosition <= numberOfEntries + 1) {
            Node newNode = new Node(newEntry);
            
            if (givenPosition == 1) {
                newNode.next = firstNode;
                firstNode = newNode;
            } else {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeAfter = nodeBefore.next;
                nodeBefore.next = newNode;
                newNode.next = nodeAfter;
            }
            numberOfEntries++;
        } else {
            throw new IndexOutOfBoundsException("Invalid position!");
        }
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        Node currentNode = firstNode;
        while (currentNode != null) {
            result[index] = currentNode.data;
            currentNode = currentNode.next;
            index++;
        }
        return result;
    }

    @Override
    public T remove(int givenPosition) {
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            T result = null;
            
            if (givenPosition == 1) {
                result = firstNode.data;
                firstNode = firstNode.next;
            } else {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.next;
                result = nodeToRemove.data;
                nodeBefore.next = nodeToRemove.next;
            }
            numberOfEntries--;
            return result;
        } else {
            throw new IndexOutOfBoundsException("Invalid position!");
        }
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            Node desiredNode = getNodeAt(givenPosition);
            desiredNode.data = newEntry;
            return true;
        }
        return false;
    }

    @Override
    public T getEntry(int givenPosition) {
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            return getNodeAt(givenPosition).data;
        } else {
            throw new IndexOutOfBoundsException("Invalid position!");
        }
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }
        return found;
    }

    @Override
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public int getLength() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    private Node getNodeAt(int givenPosition) {
        Node currentNode = firstNode;
        
        for (int counter = 1; counter < givenPosition; counter++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
}
