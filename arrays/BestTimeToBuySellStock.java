package arrays;

//Author @dsa.java.hub

/**
 * LeetCode 121: Best Time to Buy and Sell Stock.
 * One pass: remember the cheapest price so far and, for every day, ask "what if I sold today?".
 */
public class BestTimeToBuySellStock {

    static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int day = 0; day < prices.length; day++) {
            int price = prices[day];
            if (price < minPrice) {
                minPrice = price;                                 // cheapest day so far: the best day to buy
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);  // sell today?
            }
            System.out.println("day " + day + " price " + price + " min " + minPrice
                    + " profit " + (price - minPrice) + " best " + maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("answer " + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
