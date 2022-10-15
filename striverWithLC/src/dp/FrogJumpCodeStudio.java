package dp;

import java.util.Arrays;

// SOLVED IN 15mins.
public class FrogJumpCodeStudio {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        if(n<=1)
            return 0;

        dp[0] = 0;
        dp[1] = Math.abs(heights[0] - heights[1]);
        process(dp, heights, n-1);
        return dp[n-1];
    }

    static int process(int[] dp, int[] heights, int n){
        if(n<=1)
            return dp[n];
        if(dp[n] != -1)
            return dp[n];

        // reccurence
        // dp[n] = min(process(n-2) + |a[n] - a[n-2]|, process(n-1) + |a[n] + a[n-1}|
        dp[n] = Math.min(
                process(dp, heights, n - 2) + Math.abs(heights[n] - heights[n - 2]),
                process(dp, heights, n - 1) + Math.abs(heights[n] - heights[n - 1])
        );

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(frogJump(4, new int[]{10,20,30,10}));
    }


}