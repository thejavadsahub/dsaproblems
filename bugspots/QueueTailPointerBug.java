package bugspots;

//Author @dsa.java.hub
//Spot the bug 👀
public class QueueTailPointerBug {

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
            tail.next = node; // BUG: tail is never advanced to node
        }
    }

    int dequeue() {
        int value = head.value;
        head = head.next;
        return value;
    }

    public static void main(String[] args) {
        QueueTailPointerBug queue = new QueueTailPointerBug();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
    }
}
