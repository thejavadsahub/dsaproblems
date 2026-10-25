package heaps;

//Author @dsa.java.hub
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LeetCode 23: Merge k Sorted Lists (min-heap).
 * The smallest number overall is always at the FRONT of one of the k lists. Keep one node per list in a
 * min-heap; take the smallest, then put the next node of that same list into the heap. The heap never
 * holds more than k nodes, so each of the n numbers costs O(log k): O(n log k) in total.
 */
public class MergeKSortedLists {

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    record Entry(Node node, int list) { }

    static Node build(int... values) {
        Node dummy = new Node(0);
        Node tail = dummy;
        for (int value : values) {
            tail.next = new Node(value);
            tail = tail.next;
        }
        return dummy.next;
    }

    static String describe(PriorityQueue<Entry> heap) {
        List<Entry> entries = new ArrayList<>(heap);
        entries.sort(Comparator.comparingInt((Entry e) -> e.node().value).thenComparingInt(Entry::list));
        List<String> parts = new ArrayList<>();
        for (Entry e : entries) parts.add(e.node().value + " (list " + e.list() + ")");
        return parts.toString();
    }

    public static void main(String[] args) {
        Node[] lists = {build(1, 4, 5), build(1, 3, 4), build(2, 6)};
        System.out.println("lists: [1,4,5]  [1,3,4]  [2,6]");

        PriorityQueue<Entry> heap = new PriorityQueue<>(
                Comparator.comparingInt((Entry e) -> e.node().value).thenComparingInt(Entry::list));
        for (int i = 0; i < lists.length; i++) heap.add(new Entry(lists[i], i));
        System.out.println("heap starts with the first node of each list: " + describe(heap));

        List<Integer> merged = new ArrayList<>();
        int step = 0;
        while (!heap.isEmpty()) {
            Entry smallest = heap.poll();
            merged.add(smallest.node().value);
            step++;
            String pushed = "that list is finished";
            if (smallest.node().next != null) {
                heap.add(new Entry(smallest.node().next, smallest.list()));
                pushed = "push " + smallest.node().next.value + " from list " + smallest.list();
            }
            System.out.println("step " + step + ": take " + smallest.node().value + " (list " + smallest.list() + "), "
                    + pushed + " | heap " + describe(heap));
        }
        System.out.println("merged: " + merged);
    }
}
