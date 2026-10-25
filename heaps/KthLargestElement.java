package heaps;

//Author @dsa.java.hub
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LeetCode 215: Kth Largest Element, with a min-heap of size k.
 * Keep the k biggest numbers seen so far in a min-heap. Its root is the smallest of them, so a new
 * number only matters if it beats the root. When the stream ends, the root is the kth largest.
 * That costs O(n log k) instead of sorting everything in O(n log n).
 */
public class KthLargestElement {

    public static void main(String[] args) {
        int[] nums = {4, 9, 2, 7, 1, 8, 5, 6, 3};
        int k = 3;

        PriorityQueue<Integer> heap = new PriorityQueue<>();      // a min-heap
        for (int x : nums) {
            String action;
            if (heap.size() < k) {
                heap.offer(x);
                action = "push";
            } else if (x > heap.peek()) {
                int removed = heap.poll();                        // drop the smallest of the top k
                heap.offer(x);
                action = "replace " + removed;
            } else {
                action = "skip (<= " + heap.peek() + ")";
            }
            System.out.println(x + " -> " + action + "  heap=" + Arrays.toString(heap.toArray()));
        }
        System.out.println("kth largest = " + heap.peek());

        Integer[] sortedDescending = Arrays.stream(nums).boxed()
                .sorted(Collections.reverseOrder()).toArray(Integer[]::new);
        System.out.println("check sorted desc: " + Arrays.toString(sortedDescending) + " -> " + sortedDescending[k - 1]);
    }
}
