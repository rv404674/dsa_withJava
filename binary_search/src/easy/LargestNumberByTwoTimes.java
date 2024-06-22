package easy;

import java.util.Arrays;

public class LargestNumberByTwoTimes {
    public boolean solve(int[] nums) {
        // O(nlogn)
        int n = nums.length;

        Arrays.sort(nums);
        int secondLargest = nums[n-2];
        int largest = nums[n-1];

        if(largest > 2*secondLargest)
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        LargestNumberByTwoTimes largestNumberByTwoTimes = new LargestNumberByTwoTimes();
        int[][] testCases = {
                {3,6,9},
                {1,5},
                {1,2},
                {1,1}
        };

        boolean[] ans = {false, true, false, false};

        for(int i=0; i<testCases.length; i++){
            System.out.println(largestNumberByTwoTimes.solve(testCases[i]));
            assert(largestNumberByTwoTimes.solve(testCases[i]) == ans[i]);}

    }
}
