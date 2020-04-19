package com.arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
 * Approach-3
 *
 * we can simply go on crawling over the slope and keep on adding the profit obtained
 * from every consecutive transaction.
 *
 * we can directly keep on adding the difference between the consecutive numbers of the array
 * if the second number is larger than the first one, and at the total sum we obtain will be the maximum profit.
 *
 * Since there is no transaction limit, we just calculate max amount of profit, which is
 * "any price raise is profit".
 *
 * From the above graph, we can observe that the sum A+B+C is equal to the difference D
 * corresponding to the difference between the heights of the consecutive peak and valley.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *
 *  Complexity Analysis
 *
 * Time complexity : O(n). Single pass.
 *
 * Space complexity: O(1). Constant space needed.
 */
public class StockBuySellToMaximizeProfit_PeakValleyApproach {

    public static int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public static void main (String args[]){
        int[] price  = {100,60,120,110,90,200};
        int maxProfit= maxProfit(price);
        System.out.println(maxProfit);

    }
}
