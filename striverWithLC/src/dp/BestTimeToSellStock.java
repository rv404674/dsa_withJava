package dp;

import java.util.Arrays;

public class BestTimeToSellStock {
    // came up with a two pointer approach in interview in 30mins.
    // this is the two pointer approach
    // O(2N)
    // AC
    public static int maxProfitTwoPointer(int[] prices) {
        //  {12,10,3,7,39,10,22,10,5,40}
        // (3,39) (10,22) (5,40)
        if(prices.length == 1)
            return 0;

        int totalProfit = 0;
        int i=1, j=0;
        int n = prices.length;

        while(i<n && j<n){
            // if (cost > selling) move
            if(prices[i] < prices[j]){
                i+=1;
                j+=1;
            } else {
                // keep moving as long as you have a greater price
                while(i+1<n && prices[i+1]>prices[i])
                    i+=1;
                int curProfit = prices[i]-prices[j];
                totalProfit += curProfit;

                j = i+1;
                i = j+1;
            }
        }

        return totalProfit;
    }

    // Striver Dp Solutions - Dp can be used to solve most variations of stock and sell.
    // DP Soln - https://www.youtube.com/watch?v=nGJmxkUJQGs
    // Not easy to come up with dp Solution.
    // NOTE: Thought Process
    // At any point you can do sell, buy, and you need to find max profit among all the ways.
    // all the ways - recursion.
    // for params (index, buy)
    // NOTE: You need to keep track that whether you have already bought something if yes, you cant biu again.
    // TC - O(2N)
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return recurse(0,1,prices,dp);
    }

    public int recurse(int index, int buy, int[] prices, int[][] dp){
        int profit = 0;

        if(index == prices.length)
            return profit;
        if(dp[index][buy] != -1)
            return dp[index][buy];

        if(buy == 1){
            // you can buy
            profit = Math.max(
                    // if you bought you cant buy again
                    -prices[index] + recurse(index+1, 0, prices, dp),
                    0 + recurse(index+1, 1, prices, dp)
            );
        } else {
            // you can only sell
            profit = Math.max(
                    prices[index] + recurse(index +1, 1, prices, dp),
                    // if you decided to not sell
                    0 + recurse(index+1, 0, prices, dp)
            );
        }

        dp[index][buy] = profit;
        return profit;
    }

    public static void main(String[] args) {
        int[] ut1 = {7,1,5,3,6,4};
        System.out.println(maxProfitTwoPointer(ut1));
    }
}
