package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem link - https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

// TC - O(N), SC - 2 * O(N)
public class MaxSumOfNonAdjacent {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.
        if(nums.size() == 1)
            return nums.get(0);

        int[] dp = new int[nums.size() + 1];
        Arrays.fill(dp, -1);
        dp[0] = nums.get(0);
        // either pick nums[1]. if yes you can't get nums[0]
        dp[1] = Math.max(dp[0], nums.get(1));

        process(nums.size()-1, dp, nums);

        return dp[nums.size()-1];
    }

    public static int process(int n, int[] dp, List<Integer> nums){
        if(n<=1)
            return dp[n];
        if(dp[n] != -1)
            return dp[n];

        // if you pick it,you can add the current element + element below it.
        int pick = nums.get(n) + process(n-2, dp , nums);
        int notpick = process(n-1, dp, nums);

        dp[n] = Math.max(pick, notpick);
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(MaxSumOfNonAdjacent.maximumNonAdjacentSum(new ArrayList<>(Arrays.asList(1,2,4))));
        System.out.println(MaxSumOfNonAdjacent.maximumNonAdjacentSum(new ArrayList<>(Arrays.asList(2,1,9,10,20,5,6))));
    }
}
