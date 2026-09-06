package quicktips;

//Author @dsa.java.hub
public class BstVsSortedArray {

    public static void main(String[] args) {
        // Both BST search and binary search on a sorted array are O(log n) average.
        // The difference is in what else you need to do with the data:
        //   - Sorted array: O(log n) search, but O(n) insertion (must shift elements to stay sorted).
        //   - BST: O(log n) average insertion AND search, no shifting needed -
        //     but an unbalanced BST (e.g. inserting already-sorted data) degrades to O(n), like a linked list.

        int[] sortedArray = {10, 20, 30, 40, 50, 60, 70};
        int target = 50;
        int low = 0, high = sortedArray.length - 1, foundIndex = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedArray[mid] == target) {
                foundIndex = mid;
                break;
            } else if (sortedArray[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        System.out.println("Binary search on sorted array found " + target + " at index " + foundIndex);
        System.out.println("Same value found via BST.search() in BinarySearchTree.java - same big-O, different trade-offs.");
    }
}
