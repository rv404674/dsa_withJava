package dp;

import java.util.Arrays;

/**
 * Solved in 5mins.v
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        dp[0] = 1;
        dp[1] = 1;

        if (n<=1)
            return dp[n];

        process(dp, n);
        return dp[n];
    }

    public int process(int[] dp, int n){
        if(n<=1)
            return dp[n];
        if(dp[n] != -1)
            return dp[n];

        dp[n] = process(dp, n-1) + process(dp, n-2);
        return dp[n];
    }
}
