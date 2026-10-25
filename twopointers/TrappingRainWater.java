package twopointers;

//Author @dsa.java.hub

/**
 * LeetCode 42: Trapping Rain Water (two pointers).
 * The water above a bar is (the lower of the tallest bar on its left and the tallest bar on its right) minus its own height.
 * Two pointers walk in from both ends. Whichever side is currently lower is the side we can be sure about:
 * its water level is decided by its own side's maximum, because the other side already has something at least as tall.
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        while (left < right) {
            String move;
            int added;
            if (height[left] < height[right]) {                      // the left side is lower: settle it
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                    added = 0;                                       // a new tallest bar on the left holds nothing
                } else {
                    added = leftMax - height[left];
                }
                move = "left  (index " + left + ", height " + height[left] + ")";
                left++;
            } else {                                                 // the right side is lower or equal: settle it
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                    added = 0;
                } else {
                    added = rightMax - height[right];
                }
                move = "right (index " + right + ", height " + height[right] + ")";
                right--;
            }
            water += added;
            System.out.println("settle " + move + "  leftMax=" + leftMax + " rightMax=" + rightMax
                    + "  water +" + added + " = " + water);
        }
        System.out.println("answer = " + water);
    }
}
