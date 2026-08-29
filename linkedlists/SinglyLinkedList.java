package linkedlists;

//Author @dsa.java.hub
public class SinglyLinkedList {

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
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.print();
    }
}
