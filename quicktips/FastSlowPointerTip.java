package quicktips;

//Author @dsa.java.hub
public class FastSlowPointerTip {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70};

        int slow = 0;
        int fast = 0;
        while (fast < arr.length) {
            System.out.println("slow=" + slow + " (" + arr[slow] + "), fast=" + fast + " (" + arr[fast] + ")");
            slow += 1;
            fast += 2;
        }
        System.out.println("Fast pointer reaches the end in half the steps of slow - the core idea behind cycle detection and finding the middle of a list.");
    }
}
