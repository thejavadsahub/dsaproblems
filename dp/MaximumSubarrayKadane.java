package dp;

//Author @dsa.java.hub

/**
 * LeetCode 53: Maximum Subarray (Kadane's algorithm).
 * At every number there are only two choices: add it to the running subarray, or throw the running
 * subarray away and start fresh at this number. A running sum that has gone negative can only hurt,
 * so we start fresh. current = max(x, current + x); best remembers the highest current seen.
 */
public class MaximumSubarrayKadane {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int current = nums[0];
        int best = nums[0];
        int start = 0;
        int bestStart = 0;
        int bestEnd = 0;
        System.out.println("i=0 x=" + nums[0] + "  current=" + current + "  best=" + best);
        for (int i = 1; i < nums.length; i++) {
            String choice;
            if (current + nums[i] >= nums[i]) {
                current = current + nums[i];
                choice = "extend";
            } else {
                current = nums[i];
                start = i;
                choice = "restart";
            }
            if (current > best) {
                best = current;
                bestStart = start;
                bestEnd = i;
            }
            System.out.println("i=" + i + " x=" + nums[i] + "  " + choice + "  current=" + current + "  best=" + best);
        }

        StringBuilder subarray = new StringBuilder("[");
        for (int i = bestStart; i <= bestEnd; i++) {
            subarray.append(nums[i]).append(i < bestEnd ? ", " : "");
        }
        System.out.println("answer = " + best + " from the subarray " + subarray + "] (indices " + bestStart + ".." + bestEnd + ")");
    }
}
