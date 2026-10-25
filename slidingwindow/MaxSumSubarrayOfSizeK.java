package slidingwindow;

//Author @dsa.java.hub

/**
 * Sliding window: the maximum sum of any k consecutive numbers (here k = 4).
 * Brute force adds up all k numbers of every window again. The sliding window adds the one number
 * that enters and subtracts the one that leaves, so each step costs 2 operations instead of k.
 */
public class MaxSumSubarrayOfSizeK {

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 1, 3, 2, 9, 4, 1, 6};
        int k = 4;

        // Brute force: re-add all k elements of every window
        int bruteOps = 0;
        int bruteBest = Integer.MIN_VALUE;
        int bruteAt = -1;
        for (int start = 0; start + k <= nums.length; start++) {
            int sum = 0;
            for (int j = start; j < start + k; j++) {
                sum += nums[j];
                bruteOps++;
            }
            if (sum > bruteBest) {
                bruteBest = sum;
                bruteAt = start;
            }
        }

        // Sliding window: add the new element, subtract the one that left
        int slideOps = 0;
        int sum = 0;
        for (int j = 0; j < k; j++) {
            sum += nums[j];
            slideOps++;
        }
        int best = sum;
        int bestAt = 0;
        StringBuilder windowSums = new StringBuilder(String.valueOf(sum));
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            slideOps += 2;
            windowSums.append(", ").append(sum);
            if (sum > best) {
                best = sum;
                bestAt = i - k + 1;
            }
        }

        System.out.println("window sums: [" + windowSums + "]");
        System.out.println("brute force: best " + bruteBest + " at index " + bruteAt + ", ops " + bruteOps);
        System.out.println("sliding:     best " + best + " at index " + bestAt + ", ops " + slideOps);
    }
}
