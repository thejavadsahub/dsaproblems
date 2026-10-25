package backtracking;

//Author @dsa.java.hub
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode 78: Subsets (backtracking).
 * At every step: record the current subset, then for each remaining number CHOOSE it, explore
 * further, and UNDO the choice so the next number starts from a clean slate. The log shows the
 * choose / record / undo rhythm for [1, 2, 3], which produces all 2^3 = 8 subsets.
 */
public class Subsets {

    static List<List<Integer>> result = new ArrayList<>();
    static List<String> log = new ArrayList<>();

    static void explore(int[] nums, int start, Deque<Integer> path) {
        result.add(new ArrayList<>(path));                        // every path is a subset: record a copy
        log.add("record " + path);
        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);                                // choose
            log.add("choose " + nums[i]);
            explore(nums, i + 1, path);                           // explore with the choice made
            path.removeLast();                                    // undo
            log.add("undo " + nums[i]);
        }
    }

    public static void main(String[] args) {
        explore(new int[]{1, 2, 3}, 0, new ArrayDeque<>());
        System.out.println(String.join(" | ", log));
        System.out.println(result.size() + " subsets: " + result);
    }
}
