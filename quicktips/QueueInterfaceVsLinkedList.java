package quicktips;

//Author @dsa.java.hub
public class QueueInterfaceVsLinkedList {

    public static void main(String[] args) {
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println("Poll: " + queue.poll());
        System.out.println("Peek: " + queue.peek());
        System.out.println("Remaining size: " + queue.size());
    }
}
