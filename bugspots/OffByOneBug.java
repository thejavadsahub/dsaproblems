package bugspots;

//Author @dsa.java.hub
//Spot the bug 👀
class OffByOneBug {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50};

        for (int i = 0; i <= nums.length; i++) {   // BUG: should be i < nums.length
            System.out.println(nums[i]);
        }
    }
}
