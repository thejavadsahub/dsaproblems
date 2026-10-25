package backtracking;

//Author @dsa.java.hub
import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 46: Permutations (backtracking).
 * Build a permutation one position at a time. At each position try every number that is not used yet:
 * CHOOSE it, explore the next position, then UNDO the choice so the next number gets its turn.
 * A permutation is complete when it has as many numbers as the input: record a copy of it.
 * For n numbers there are n! permutations (3! = 6 here).
 */
public class Permutations {

    static List<List<Integer>> result = new ArrayList<>();
    static List<String> log = new ArrayList<>();

    static void explore(int[] nums, boolean[] used, List<Integer> current) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));                      // complete: record a copy
            log.add("record " + current);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;                                            // choose
            current.add(nums[i]);
            log.add("choose " + nums[i]);
            explore(nums, used, current);
            current.remove(current.size() - 1);                        // undo
            used[i] = false;
            log.add("undo " + nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        explore(nums, new boolean[nums.length], new ArrayList<>());
        System.out.println(String.join(" | ", log));
        System.out.println(result.size() + " permutations: " + result);
    }
}
