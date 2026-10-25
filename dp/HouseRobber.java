package dp;

//Author @dsa.java.hub

/**
 * LeetCode 198: House Robber (dynamic programming).
 * You cannot rob two neighbouring houses. For each house there are two choices:
 *   rob it    -> its money + the best total up to two houses back;
 *   skip it   -> the best total up to the previous house.
 * Keep the better of the two. Only the last two answers are needed, so two variables are enough.
 */
public class HouseRobber {

    public static void main(String[] args) {
        int[] money = {2, 7, 9, 3, 1};

        int twoBack = 0;                                                  // best total up to two houses back
        int oneBack = 0;                                                  // best total up to the previous house
        for (int i = 0; i < money.length; i++) {
            int rob = twoBack + money[i];
            int skip = oneBack;
            int best = Math.max(rob, skip);
            System.out.println("house " + i + " (money " + money[i] + "): rob = " + twoBack + " + " + money[i] + " = " + rob
                    + " | skip = " + skip + " | best so far = " + best + (rob > skip ? "  (rob it)" : "  (skip it)"));
            twoBack = oneBack;
            oneBack = best;
        }
        System.out.println("answer = " + oneBack);
    }
}
