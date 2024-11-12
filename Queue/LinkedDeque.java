package cheatsheet.Queue;

public final class LinkedDeque<T> implements DequeInterface<T> {
    private DLNode firstNode; // References node at front of deque
    private DLNode lastNode;  // References node at back of deque

    public LinkedDeque() {
        firstNode = null;
        lastNode = null;
    }

    @Override
    public void addToFront(T newEntry) {
        DLNode newNode = new DLNode(null, newEntry, firstNode);

        if (isEmpty()) {
            lastNode = newNode;
        } else {
            firstNode.setPreviousNode(newNode);
        }
        firstNode = newNode;
    }

    @Override
    public void addToBack(T newEntry) {
        DLNode newNode = new DLNode(lastNode, newEntry, null);

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
    }

    @Override
    public T removeFront() {
        if (isEmpty()) {
            throw new EmptyQueueException("Deque is empty.");
        }

        T front = firstNode.getData();
        firstNode = firstNode.getNextNode();

        if (firstNode == null) {
            lastNode = null;
        } else {
            firstNode.setPreviousNode(null);
        }
        return front;
    }

    @Override
    public T removeBack() {
        if (isEmpty()) {
            throw new EmptyQueueException("Deque is empty.");
        }

        T back = lastNode.getData();
        lastNode = lastNode.getPreviousNode();

        if (lastNode == null) {
            firstNode = null;
        } else {
            lastNode.setNextNode(null);
        }
        return back;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException("Deque is empty.");
        }
        return firstNode.getData();
    }

    @Override
    public T getBack() {
        if (isEmpty()) {
            throw new EmptyQueueException("Deque is empty.");
        }
        return lastNode.getData();
    }

    @Override
    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
    }

    public void printDeque() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }

        StringBuilder dequeContents = new StringBuilder("Deque: ");
        DLNode currentNode = firstNode;
        while (currentNode != null) {
            dequeContents.append(currentNode.getData()).append(" ");
            currentNode = currentNode.getNextNode();
        }
        System.out.println(dequeContents.toString().trim());
    }

    private class DLNode {
        private T data;
        private DLNode next;
        private DLNode previous;

        private DLNode(DLNode previousNode, T dataPortion, DLNode nextNode) {
            data = dataPortion;
            next = nextNode;
            previous = previousNode;
        }

        private T getData() {
            return data;
        }

        private void setData(T newData) {
            data = newData;
        }

        private DLNode getNextNode() {
            return next;
        }

        private void setNextNode(DLNode nextNode) {
            next = nextNode;
        }

        private DLNode getPreviousNode() {
            return previous;
        }

        private void setPreviousNode(DLNode previousNode) {
            previous = previousNode;
        }
    }
}
