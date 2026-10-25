package dp;

//Author @dsa.java.hub

/**
 * LeetCode 70: Climbing Stairs, plain recursion vs memoization.
 * ways(n) = ways(n - 1) + ways(n - 2). Plain recursion solves the same small problems again and
 * again (the number of calls explodes). Memoization stores each answer the first time, so every
 * n is solved only once.
 */
public class ClimbingStairs {

    static int naiveCalls = 0;
    static int memoCalls = 0;

    static int naive(int n) {
        naiveCalls++;
        if (n <= 1) return 1;
        return naive(n - 1) + naive(n - 2);
    }

    static int memo(int n, Integer[] saved) {
        memoCalls++;
        if (n <= 1) return 1;
        if (saved[n] != null) return saved[n];                    // already solved: just look it up
        saved[n] = memo(n - 1, saved) + memo(n - 2, saved);
        return saved[n];
    }

    public static void main(String[] args) {
        for (int n : new int[]{5, 10, 30, 40}) {
            naiveCalls = 0;
            memoCalls = 0;
            int plain = naive(n);
            int memoized = memo(n, new Integer[n + 1]);
            System.out.printf("climbStairs(%d) = %d | naive calls %,d | memo calls %d%n", n, plain, naiveCalls, memoCalls);
            if (plain != memoized) throw new IllegalStateException("the two versions must agree");
        }
    }
}
