package queues;

//Author @dsa.java.hub
public class LinkedQueue {

    private static class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;

    void enqueue(int value) {
        Node node = new Node(value);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    int dequeue() {
        int value = head.value;
        head = head.next;
        if (head == null) tail = null;
        return value;
    }

    boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("isEmpty: " + queue.isEmpty());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("isEmpty: " + queue.isEmpty());
    }
}
