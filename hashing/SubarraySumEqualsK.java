package hashing;

//Author @dsa.java.hub
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 560: Subarray Sum Equals K (prefix sum + hash map).
 * A subarray from i+1 to j has sum k exactly when prefix[j] - prefix[i] = k. So for every new prefix
 * sum, count how many EARLIER prefix sums equal (prefix - k). The map stores how often each
 * prefix sum has appeared, which turns an O(n^2) search into one pass.
 */
public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;

        Map<Integer, Integer> prefixCounts = new LinkedHashMap<>();
        prefixCounts.put(0, 1);                                   // the empty prefix, so subarrays starting at index 0 count
        int prefix = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int need = prefix - k;                                // the earlier prefix sum that would leave exactly k
            int hit = prefixCounts.getOrDefault(need, 0);
            count += hit;
            prefixCounts.merge(prefix, 1, Integer::sum);
            System.out.printf("i=%d x=%d prefix=%d need=%d hit=%d count=%d map=%s%n",
                    i, nums[i], prefix, need, hit, count, prefixCounts);
        }

        int bruteCount = 0;
        int sums = 0;
        List<String> found = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                sums++;
                if (sum == k) {
                    bruteCount++;
                    found.add(Arrays.toString(Arrays.copyOfRange(nums, i, j + 1)));
                }
            }
        }
        System.out.println("prefix+map count=" + count + " | brute force count=" + bruteCount
                + " in " + sums + " sums: " + found);
    }
}
