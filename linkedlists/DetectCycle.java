package linkedlists;

//Author @dsa.java.hub
public class DetectCycle {

    private static class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        System.out.println("Non-cyclic list has cycle: " + hasCycle(a));

        d.next = b; // introduce a cycle: 4 -> back to 2
        System.out.println("Cyclic list has cycle: " + hasCycle(a));
    }
}
