package arrays;

//Author @dsa.java.hub
import java.util.Arrays;

/**
 * LeetCode 238: Product of Array Except Self (no division).
 * The answer for position i is (product of everything to the left of i) x (product of everything to the right).
 * Pass 1 fills result[i] with the left products. Pass 2 walks from the right, keeping a running product
 * of the right side, and multiplies it in. Two passes, O(n) time, and no extra array besides the result.
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int n = nums.length;
        int[] result = new int[n];
        System.out.println("nums = " + Arrays.toString(nums));

        System.out.println("pass 1, product of everything to the LEFT:");
        result[0] = 1;                                             // nothing is to the left of the first element
        System.out.println("  i=0: left product = 1");
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
            System.out.println("  i=" + i + ": left product = " + result[i - 1] + " x " + nums[i - 1] + " = " + result[i]);
        }

        System.out.println("pass 2, multiply in the product of everything to the RIGHT:");
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            int before = result[i];
            result[i] = result[i] * right;
            System.out.println("  i=" + i + ": " + before + " x right product " + right + " = " + result[i]);
            right *= nums[i];
        }
        System.out.println("answer = " + Arrays.toString(result));
    }
}
