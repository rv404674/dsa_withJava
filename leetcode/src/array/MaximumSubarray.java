package array;

import static java.lang.Math.max;

public class MaximumSubarray {
    /**
     * Appr1 - O(N*N), space - O(1) Use two loops
     * Appr2 - O(N), kadane algo
     */
    public static int maxSubArray(int[] nums) {
        if(nums.length <= 1)
            return nums[0];

        int maxRes = Integer.MIN_VALUE;
        int cur  = 0;

        for(int i=0; i<nums.length; i++){
            cur = cur + nums[i];
            if(cur > maxRes) {
                maxRes = max(maxRes, cur);
            }

            cur = cur < 0 ? 0 : cur;
        }

        return maxRes;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{5,9,-8,3,4,9,-20}));
        System.out.println(maxSubArray(new int[]{1}));
    }
}
