package queues;

//Author @dsa.java.hub
public class ArrayQueue {

    private int[] data;
    private int front;
    private int rear;
    private int size;

    ArrayQueue(int capacity) {
        data = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    void enqueue(int value) {
        rear = (rear + 1) % data.length;
        data[rear] = value;
        size++;
    }

    int dequeue() {
        int value = data[front];
        front = (front + 1) % data.length;
        size--;
        return value;
    }

    int peek() {
        return data[front];
    }

    boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("isEmpty: " + queue.isEmpty());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("isEmpty: " + queue.isEmpty());
    }
}
