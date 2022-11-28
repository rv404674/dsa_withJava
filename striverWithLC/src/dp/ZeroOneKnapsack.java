package dp;

// Video link - https://www.youtube.com/watch?v=GqOmJHQZivw
// PS - https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

// NOTE: Thought Process
// 1. express in terms of index
// 2. do something over it. (pick it or not pick)
// 3. Apply Max
// 4. Base condition.

import java.util.Arrays;

public class ZeroOneKnapsack {
    static int knapSack(int W, int wt[], int val[], int n) {
        // your code here
        int[][] dp = new int[n][W+1];
        for(int[] x:dp)
            Arrays.fill(x, -1);

        return recurse(n-1, W, wt, val, dp);
    }

    static int recurse(int index, int w, int wt[], int val[], int[][] dp){
        if(index == 0){
            if(wt[0] <= w)
                return val[0];
            else
                return 0;
        }

        // not pick
        int notPick = 0 + recurse(index-1, w, wt, val, dp);
        // pick
        int pick = Integer.MIN_VALUE;
        if(wt[index] <= w){
            pick = val[index] + recurse(index-1, w - wt[index], wt, val, dp);
        }

        dp[index][w] = Math.max(notPick, pick);
        return dp[index][w];
    }
}
