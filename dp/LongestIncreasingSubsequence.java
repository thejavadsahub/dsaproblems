package dp;

//Author @dsa.java.hub
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 300: Longest Increasing Subsequence, in O(n log n).
 * Keep a list "tails" where tails[k] is the smallest possible last number of an increasing subsequence
 * of length k + 1. For each number, binary-search the first tail that is >= it and replace that tail
 * (a smaller tail is always better); if it is bigger than every tail, append it. The LENGTH of tails is
 * the answer, but tails itself is not necessarily a real subsequence of the input.
 * A slower O(n^2) dynamic programming version checks the result.
 */
public class LongestIncreasingSubsequence {

    static int lengthWithTails(int[] nums) {
        List<Integer> tails = new ArrayList<>();
        for (int x : nums) {
            int low = 0;
            int high = tails.size();
            while (low < high) {                                         // first position whose tail is >= x
                int mid = (low + high) / 2;
                if (tails.get(mid) < x) low = mid + 1;
                else high = mid;
            }
            String action;
            if (low == tails.size()) {
                tails.add(x);
                action = "bigger than every tail -> append";
            } else {
                action = "replaces " + tails.get(low) + " at position " + low;
                tails.set(low, x);
            }
            System.out.println("x=" + x + ": " + action + "  tails=" + tails);
        }
        return tails.size();
    }

    static int lengthWithDp(int[] nums) {
        int[] best = new int[nums.length];                               // best[i] = longest subsequence ending at i
        Arrays.fill(best, 1);
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) best[i] = Math.max(best[i], best[j] + 1);
            }
            answer = Math.max(answer, best[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("nums = " + Arrays.toString(nums));
        int answer = lengthWithTails(nums);
        System.out.println("answer = " + answer + " (O(n^2) dp check gives " + lengthWithDp(nums) + ")");
    }
}
