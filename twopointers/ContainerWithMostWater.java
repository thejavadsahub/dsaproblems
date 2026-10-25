package twopointers;

//Author @dsa.java.hub

/**
 * LeetCode 11: Container With Most Water (two pointers).
 * Start with the widest container (left and right ends). The water level is limited by the shorter
 * wall, so moving the taller wall can never help. Always move the pointer at the shorter wall.
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int left = 0;
        int right = height.length - 1;
        int best = 0;
        int checks = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            checks++;
            System.out.println("L=" + left + " R=" + right + " area=" + area);
            best = Math.max(best, area);
            if (height[left] < height[right]) left++;
            else right--;
        }

        int bruteBest = 0;
        int bruteChecks = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                bruteBest = Math.max(bruteBest, Math.min(height[i], height[j]) * (j - i));
                bruteChecks++;
            }
        }

        System.out.println("two pointers: best " + best + " in " + checks + " checks");
        System.out.println("brute force:  best " + bruteBest + " in " + bruteChecks + " checks");
    }
}
