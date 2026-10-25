package linkedlists;

//Author @dsa.java.hub

/**
 * LeetCode 141: Linked List Cycle, with a step-by-step trace of Floyd's fast and slow pointers.
 * Slow moves 1 node per step, fast moves 2. In a list with a cycle the fast pointer laps the slow
 * one and they meet inside the cycle. In a list without a cycle, fast reaches null first.
 * (DetectCycle.java shows the same idea on a shorter list; this one prints every step.)
 */
public class LinkedListCycle {

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    static boolean hasCycle(Node head, boolean trace) {
        Node slow = head;
        Node fast = head;
        int step = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            step++;
            if (trace) System.out.println("step " + step + ": slow=" + slow.value + " fast=" + fast.value);
            if (slow == fast) {
                if (trace) System.out.println("cycle found at node " + slow.value + " after " + step + " steps");
                return true;
            }
        }
        return false;
    }

    static Node[] chain(int length) {
        Node[] nodes = new Node[length];
        for (int i = 0; i < length; i++) nodes[i] = new Node(i + 1);
        for (int i = 0; i < length - 1; i++) nodes[i].next = nodes[i + 1];
        return nodes;
    }

    public static void main(String[] args) {
        Node[] withCycle = chain(8);
        withCycle[7].next = withCycle[3];                         // 8 -> 4 closes the cycle: 1..8, then back to 4
        hasCycle(withCycle[0], true);

        Node[] withoutCycle = chain(6);                           // 1 -> 2 -> ... -> 6 -> null
        System.out.println("no-cycle list: hasCycle=" + hasCycle(withoutCycle[0], false));
    }
}
