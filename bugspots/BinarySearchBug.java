package bugspots;

//Author @dsa.java.hub
//Spot the bug 👀
public class BinarySearchBug {

    static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) low = mid + 1;       // BUG
            else if (arr[mid] < target) high = mid - 1; // BUG
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sortedArr = {2, 4, 6, 8, 10, 12, 14};
        System.out.println("Searching for 14, found at index: " + binarySearch(sortedArr, 14));
    }
}