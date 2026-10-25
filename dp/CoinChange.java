package dp;

//Author @dsa.java.hub
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 322: Coin Change. Greedy fails, a DP table wins.
 * With coins {1, 3, 4} and amount 6, "always take the biggest coin" gives 4+1+1 = 3 coins,
 * but 3+3 is only 2 coins. dp[x] = fewest coins that make x = 1 + the best dp[x - coin].
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 3, 4};
        int amount = 6;

        int[] dp = new int[amount + 1];
        int[] lastCoin = new int[amount + 1];                     // which coin gave the best answer for each amount
        Arrays.fill(dp, amount + 1);                              // "infinity": more coins than could ever be needed
        dp[0] = 0;                                                // 0 coins make amount 0

        for (int x = 1; x <= amount; x++) {
            StringBuilder tried = new StringBuilder();
            for (int coin : coins) {
                if (coin > x) continue;
                tried.append("dp[" + (x - coin) + "]+1=" + (dp[x - coin] + 1) + " ");
                if (dp[x - coin] + 1 < dp[x]) {
                    dp[x] = dp[x - coin] + 1;
                    lastCoin[x] = coin;
                }
            }
            System.out.println("dp[" + x + "] = " + dp[x] + "   (" + tried.toString().trim() + ")");
        }

        List<Integer> used = new ArrayList<>();                   // walk back through the table to list the coins
        for (int x = amount; x > 0; x -= lastCoin[x]) used.add(lastCoin[x]);

        int remaining = amount;                                   // greedy: biggest coin first
        List<Integer> greedy = new ArrayList<>();
        for (int i = coins.length - 1; i >= 0; i--) {
            while (remaining >= coins[i]) {
                remaining -= coins[i];
                greedy.add(coins[i]);
            }
        }
        System.out.println("DP: " + dp[amount] + " coins " + used + " | greedy: " + greedy.size() + " coins " + greedy);
    }
}
