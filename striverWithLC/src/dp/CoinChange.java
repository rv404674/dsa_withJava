package dp;

import java.util.Arrays;


// https://www.youtube.com/watch?v=myPeWb3Y68A&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=22
// NOTE: Thought Process
// 1. express in terms of index
// 2. pick or not pick
// NOTE: in case of infite supplies, during pick as well, you wont move to preivous index, as the same coin can be picked again.
// [1,5,6] = 11
// 3. min, max
// 4. base case

// NOTE: dont return INT_MAX else you will get overflow.
// FIXME: note make recursion tree. Will be crystal clear.
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] a:dp)
            Arrays.fill(a, -1);

        int ans = recurse(coins.length -1, amount, coins, dp);


        if(ans >= 1e9)
            return -1;
        return ans;

    }

    public int recurse(int index, int amount, int[] coins, int[][] dp){
        if(index == 0){
            if(amount % coins[0] == 0)
                return amount/coins[0];
            return (int)1e9;
        }

        if(dp[index][amount] != -1)
            return dp[index][amount];

        int notPick = 0 + recurse(index-1, amount, coins, dp);
        int pick = (int)1e9;
        if(amount >= coins[index])
            pick = 1 + Math.min(pick, recurse(index, amount - coins[index], coins, dp));

        dp[index][amount] = Math.min(notPick, pick);
        return dp[index][amount];
    }

}
