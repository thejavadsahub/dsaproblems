package linkedlists;

//Author @dsa.java.hub

/**
 * LeetCode 206: Reverse a Linked List (iterative), with a step-by-step trace.
 * Three pointers walk the list: prev (the part already reversed), curr (the node being flipped) and
 * next (the rest of the list, saved first so we do not lose it). Each step flips one arrow.
 */
public class ReverseLinkedListSteps {

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;

    void add(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
    }

    private static String show(Node node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.value).append(" -> ");
            node = node.next;
        }
        return sb.append("null").toString();
    }

    private static String label(Node node) {
        return node == null ? "null" : String.valueOf(node.value);
    }

    String show() {
        return show(head);
    }

    /** Reverses the list in place and returns the number of steps taken. */
    int reverse() {
        Node prev = null;
        Node curr = head;
        int step = 0;
        while (curr != null) {
            Node next = curr.next;       // 1. save the rest of the list
            curr.next = prev;            // 2. flip the arrow to point backwards
            prev = curr;                 // 3. prev moves forward
            curr = next;                 // 4. curr moves forward
            step++;
            System.out.printf("step %d: prev=%s curr=%s | reversed part: %s%n", step, label(prev), label(curr), show(prev));
        }
        head = prev;
        return step;
    }

    public static void main(String[] args) {
        ReverseLinkedListSteps list = new ReverseLinkedListSteps();
        for (int i = 1; i <= 5; i++) list.add(i);

        System.out.println("before: " + list.show());
        int steps = list.reverse();
        System.out.println("after:  " + list.show() + "  (new head = " + list.head.value + ", " + steps + " steps)");
    }
}
