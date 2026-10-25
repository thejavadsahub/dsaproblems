package linkedlists;

//Author @dsa.java.hub

/**
 * LeetCode 21: Merge Two Sorted Lists.
 * Keep a pointer into each list and always take the smaller front node. A dummy node in front of the
 * result means we never have to special-case "the first node". When one list runs out, the rest of
 * the other list is already sorted, so it is attached in one step.
 */
public class MergeTwoSortedLists {

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    static Node build(int... values) {
        Node dummy = new Node(0);
        Node tail = dummy;
        for (int value : values) {
            tail.next = new Node(value);
            tail = tail.next;
        }
        return dummy.next;
    }

    static String show(Node node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.value).append(" -> ");
            node = node.next;
        }
        return sb.append("null").toString();
    }

    /** Prints the merged part only: from the first node up to 'last' (the nodes after it are not merged yet). */
    static String showMerged(Node first, Node last) {
        StringBuilder sb = new StringBuilder();
        for (Node node = first; node != null; node = node.next) {
            sb.append(node.value);
            if (node == last) break;
            sb.append(" -> ");
        }
        return sb.toString();
    }

    static Node merge(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;
        while (a != null && b != null) {
            if (a.value <= b.value) {
                System.out.println("compare " + a.value + " (list 1) and " + b.value + " (list 2) -> take " + a.value
                        + " from list 1");
                tail.next = a;
                a = a.next;
            } else {
                System.out.println("compare " + a.value + " (list 1) and " + b.value + " (list 2) -> take " + b.value
                        + " from list 2");
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
            System.out.println("   merged so far: " + showMerged(dummy.next, tail));
        }
        tail.next = a != null ? a : b;                               // attach whatever is left
        System.out.println("one list is empty -> attach the rest: " + show(tail.next));
        return dummy.next;
    }

    public static void main(String[] args) {
        Node list1 = build(1, 2, 4);
        Node list2 = build(1, 3, 4);
        System.out.println("list 1: " + show(list1));
        System.out.println("list 2: " + show(list2));
        System.out.println("answer: " + show(merge(list1, list2)));
    }
}
