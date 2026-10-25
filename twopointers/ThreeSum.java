package twopointers;

//Author @dsa.java.hub
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 15: 3Sum (sort + two pointers).
 * Sort the array. Fix the first number nums[i], then look for two more that add up to -nums[i] with a
 * pointer at each end: if the sum is too small move the left pointer up, if it is too big move the
 * right pointer down. Skipping repeated numbers keeps every triplet unique.
 * This replaces about n^3 / 6 checks of every triple with about n^2 checks.
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);
        int n = nums.length;
        System.out.println("sorted: " + Arrays.toString(nums));

        List<List<Integer>> triplets = new ArrayList<>();
        int checks = 0;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                System.out.println("i=" + i + " (" + nums[i] + ") repeats the previous number -> skip");
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                checks++;
                int sum = nums[i] + nums[left] + nums[right];
                String where = "i=" + i + " l=" + left + " r=" + right + ": " + nums[i] + " + " + nums[left] + " + " + nums[right]
                        + " = " + sum;
                if (sum == 0) {
                    triplets.add(List.of(nums[i], nums[left], nums[right]));
                    System.out.println(where + " -> triplet " + triplets.get(triplets.size() - 1));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;        // skip repeated numbers
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    System.out.println(where + " -> too small, left++");
                    left++;
                } else {
                    System.out.println(where + " -> too big, right--");
                    right--;
                }
            }
        }
        System.out.println("triplets: " + triplets);
        System.out.println("checks: two pointers " + checks + " vs brute force " + (n * (n - 1) * (n - 2) / 6));
    }
}
