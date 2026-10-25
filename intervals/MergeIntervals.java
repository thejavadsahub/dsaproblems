package intervals;

//Author @dsa.java.hub
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 56: Merge Intervals.
 * Sort by start time. Then walk through once: if an interval starts before the last merged one ends,
 * they overlap, so extend the end. Otherwise start a new merged interval.
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{8, 10}, {1, 3}, {15, 18}, {2, 6}, {9, 11}, {16, 17}};

        int[][] sorted = intervals.clone();
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.println("sorted: " + Arrays.deepToString(sorted));

        List<int[]> merged = new ArrayList<>();
        for (int[] current : sorted) {
            if (!merged.isEmpty() && current[0] <= merged.get(merged.size() - 1)[1]) {
                int[] last = merged.get(merged.size() - 1);
                System.out.println(Arrays.toString(current) + ": " + current[0] + " <= " + last[1]
                        + " -> end = max(" + last[1] + "," + current[1] + ")");
                last[1] = Math.max(last[1], current[1]);          // overlap: stretch the last interval
            } else {
                String reason = merged.isEmpty() ? "first" : current[0] + " > " + merged.get(merged.size() - 1)[1];
                System.out.println(Arrays.toString(current) + ": " + reason + " -> new");
                merged.add(new int[]{current[0], current[1]});    // no overlap: start a new interval
            }
        }
        System.out.println("merged: " + Arrays.deepToString(merged.toArray()));
    }
}
