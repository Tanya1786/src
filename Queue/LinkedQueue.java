package cheatsheet.Queue;
import javax.swing.JOptionPane;

public class LinkedQueue<T> implements QueueInterface<T> {
    private Node frontNode; // References node at the front of the queue
    private Node backNode;  // References node at the back of the queue

    public LinkedQueue() {
        frontNode = null;
        backNode = null;
    }

    @Override
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);
        if (isEmpty()) {
            frontNode = newNode;
        } else {
            backNode.setNextNode(newNode);
        }
        backNode = newNode;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty.");
        } else {
            T frontData = frontNode.getData();
            frontNode = frontNode.getNextNode();
            if (frontNode == null) {
                backNode = null;
            }
            return frontData;
        }
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty.");
        } else {
            return frontNode.getData();
        }
    }

    @Override
    public boolean isEmpty() {
        return (frontNode == null) && (backNode == null);
    }

    @Override
    public void clear() {
        frontNode = null;
        backNode = null;
    }

    public void printQueue() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "Queue is empty.");
            return;
        }

        StringBuilder queueContents = new StringBuilder("Queue: ");
        Node currentNode = frontNode;
        while (currentNode != null) {
            queueContents.append(currentNode.getData()).append(" ");
            currentNode = currentNode.getNextNode();
        }
        JOptionPane.showMessageDialog(null, queueContents.toString().trim());
    }

    private class Node {
        private T data;
        private Node next;

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNextNode() {
            return next;
        }

        public void setNextNode(Node next) {
            this.next = next;
        }
    }
}
