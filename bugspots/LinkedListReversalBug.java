package bugspots;

//Author @dsa.java.hub
//Spot the bug 👀
public class LinkedListReversalBug {

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

    void reverse() {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            curr.next = prev;      // BUG: overwrites curr.next before saving it
            prev = curr;
            curr = curr.next;      // this now reads the just-overwritten pointer
        }
        head = prev;
    }

    void print() {
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            sb.append(curr.value);
            if (curr.next != null) sb.append(" -> ");
            curr = curr.next;
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        LinkedListReversalBug list = new LinkedListReversalBug();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.print("Before: ");
        list.print();
        list.reverse();
        System.out.print("After:  ");
        list.print();
    }
}
