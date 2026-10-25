package hashing;

//Author @dsa.java.hub
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum: find the two numbers that add up to the target.
 * Brute force tries every pair. A hash map remembers the numbers already seen, so for each number
 * it only asks one question: "have I seen target - number before?"
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {6, 3, 7, 11, 1, 2, 9, 10};
        int target = 19;

        int checks = 0;
        int[] brute = null;
        search:
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                checks++;
                if (nums[i] + nums[j] == target) {
                    brute = new int[]{i, j};
                    break search;
                }
            }
        }
        System.out.println("Brute force: " + Arrays.toString(brute) + " after " + checks + " checks");

        Map<Integer, Integer> seen = new HashMap<>();            // number -> index where we saw it
        int steps = 0;
        int[] fast = null;
        for (int i = 0; i < nums.length; i++) {
            steps++;
            Integer partner = seen.get(target - nums[i]);
            if (partner != null) {
                fast = new int[]{partner, i};
                break;
            }
            seen.put(nums[i], i);
        }
        System.out.println("Hash map:    " + Arrays.toString(fast) + " after " + steps + " steps");
    }
}
