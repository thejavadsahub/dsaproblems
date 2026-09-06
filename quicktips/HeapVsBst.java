package quicktips;

//Author @dsa.java.hub
public class HeapVsBst {

    public static void main(String[] args) {
        // Heap: reach for it when you only ever need the min (or max) fast, repeatedly.
        // Insert and remove-min are both O(log n), and peeking the min is O(1) - it's always the root.
        // It gives you NO ordering for the rest of the elements though.
        java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();
        int[] values = {50, 30, 70, 20, 40, 10};
        for (int v : values) minHeap.offer(v);
        System.out.println("Heap peek (min, O(1)): " + minHeap.peek());

        // BST: reach for it when you need the FULL sorted order or range queries
        // (e.g. "give me everything between 20 and 60"), not just the single min/max.
        java.util.TreeSet<Integer> bstBacked = new java.util.TreeSet<>();
        for (int v : values) bstBacked.add(v);
        System.out.println("BST in-order (full sorted set): " + bstBacked);
        System.out.println("BST range query [20, 60]: " + bstBacked.subSet(20, true, 60, true));
    }
}
