package dp;


// see striver dp playlist
// https://www.youtube.com/watch?v=ekcwMsSIzVc
// NOTE: Thought Process
// 1. express everything in terms of index
// 2. explore all possibilites.
// 3. take max
// 4. base case

import java.util.Arrays;

// here you need prev element to dtermine whether to include current element of not.
// f(index, prev_index) - not includinng id easy.
// if you include someone that becomes the prev_indx
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // dp[i][j]
        int[][] dp = new int[nums.length][nums.length + 1];
        for(int[] a: dp)
            Arrays.fill(a, -1);
        return recurse(0,-1, nums.length, nums, dp);
    }

    public int recurse(int index, int prevIndex, int n, int[] nums, int[][] dp){
        if(index == n) return 0;
        if(dp[index][prevIndex+1] != -1)
            return dp[index][prevIndex+1];

        // dont include
        int mxLen = recurse(index+1, prevIndex, n, nums, dp);
        // include
        if(prevIndex == -1 || nums[index] > nums[prevIndex]){
            mxLen = Math.max(mxLen, 1 + recurse(index+1, index, n, nums, dp));
        }

        dp[index][prevIndex+1] = mxLen;
        return mxLen;
    }
}
