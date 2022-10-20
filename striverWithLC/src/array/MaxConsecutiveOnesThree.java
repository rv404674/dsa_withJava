package array;

public class MaxConsecutiveOnesThree {
    // Prob - https://leetcode.com/problems/max-consecutive-ones-iii/
    // Two Pointer approach
    // TC - 2*O(N), SC - O(1)
    // ACCEPTED
    public int longestOnes(int[] nums, int k) {
        if(nums.length == 0)
            return 0;

        int ans = -1;
        int i=0, j=0;

        // i will move fast then j
        while(i<nums.length)
        {
            if(nums[i] == 0)
                k--;
            while(k<0){
                if(nums[j]==0)
                    k+=1;
                j+=1;
            }

            i+=1;
            ans = Math.max(ans, i-j);
        }

        return ans;
    }
}
