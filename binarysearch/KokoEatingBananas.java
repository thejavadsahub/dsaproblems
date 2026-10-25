package binarysearch;

//Author @dsa.java.hub

/**
 * LeetCode 875: Koko Eating Bananas (binary search on the answer).
 * We do not search an array, we search the eating speed k. If Koko can finish at speed k, any faster
 * speed also works, so the answer is the smallest k that fits: perfect for binary search.
 */
public class KokoEatingBananas {

    /** Hours needed to eat every pile at speed k (a pile of p bananas takes ceil(p / k) hours). */
    static long hoursNeeded(int[] piles, int k) {
        long hours = 0;
        for (int pile : piles) hours += (pile + k - 1) / k;
        return hours;
    }

    static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) high = Math.max(high, pile);       // eating the biggest pile in 1 hour always works

        int checks = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            checks++;
            long hours = hoursNeeded(piles, mid);
            System.out.println("lo=" + low + " hi=" + high + " mid=" + mid + " hours=" + hours
                    + (hours <= h ? " fits -> hi=mid" : " too slow -> lo=mid+1"));
            if (hours <= h) high = mid;
            else low = mid + 1;
        }
        System.out.println("checks=" + checks);
        return low;
    }

    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 6;
        System.out.println("answer=" + minEatingSpeed(piles, h));

        int linearChecks = 0;                                     // for comparison: try speed 1, 2, 3, ... one by one
        for (int k = 1; ; k++) {
            linearChecks++;
            if (hoursNeeded(piles, k) <= h) break;
        }
        System.out.println("linear checks=" + linearChecks + " hours@22=" + hoursNeeded(piles, 22)
                + " hours@23=" + hoursNeeded(piles, 23));
    }
}
