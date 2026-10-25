package binarysearch;

//Author @dsa.java.hub

/**
 * LeetCode 33: Search in Rotated Sorted Array.
 * A sorted array rotated at some pivot ([0,1,2,4,5,6,7] -> [4,5,6,7,0,1,2]) is no longer sorted overall,
 * but at every binary search step at least one half IS sorted. Find the sorted half, check whether the
 * target lies inside it, and keep that half or throw it away. Still O(log n).
 */
public class SearchRotatedSortedArray {

    static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.print("lo=" + low + " hi=" + high + " mid=" + mid + " (value " + nums[mid] + ")");
            if (nums[mid] == target) {
                System.out.println("  -> found");
                return mid;
            }
            if (nums[low] <= nums[mid]) {                            // the left half is sorted
                boolean inside = nums[low] <= target && target < nums[mid];
                System.out.println("  left half [" + nums[low] + ".." + nums[mid] + "] is sorted, target "
                        + (inside ? "is inside -> search left" : "is not inside -> search right"));
                if (inside) high = mid - 1;
                else low = mid + 1;
            } else {                                                 // otherwise the right half is sorted
                boolean inside = nums[mid] < target && target <= nums[high];
                System.out.println("  right half [" + nums[mid] + ".." + nums[high] + "] is sorted, target "
                        + (inside ? "is inside -> search right" : "is not inside -> search left"));
                if (inside) low = mid + 1;
                else high = mid - 1;
            }
        }
        System.out.println("range is empty -> not found");
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        for (int target : new int[]{0, 3}) {
            System.out.println("search " + target + " in [4, 5, 6, 7, 0, 1, 2]:");
            System.out.println("answer = " + search(nums, target));
        }
    }
}
