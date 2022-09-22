package array;

/*
Requirements: Exacly one solution. One element only once
NOTE: Here sorting the array wouldn't work, as that will change the order.

Two Approaches then.
1. use looping.
2. hash table.
 */

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    // O(n2)
    public static int[] twoSumAppr1(int[] nums, int target) {
        int i,j;

        for(i=0; i< nums.length; i++){
            for (j=i+1; j<nums.length; j++){
                if ( (nums[i] + nums[j]) == target){
                    return new int[] {i,j};
                }
            }
        }

        return new int[] {-1,-1};
    }

    public int[] twoSum(int[] nums, int target) {
        /*
        Approach1: Use HashMap
        time, space - O(N), O(N)
        use a HashMap
         */
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer diff = target - nums[i];
            if (hashMap.containsKey(diff)) {
                return new int[]{i, hashMap.get(diff)};
            }

            hashMap.put(nums[i], i);
        }

        return null;

    }

    public static void main(String[] args) {
        TwoSum twoSumObj = new TwoSum();

        System.out.println(Arrays.equals(twoSumObj.twoSum(new int[]{2, 7, 9, 11}, 9), new int[]{0, 1}));
        System.out.println(Arrays.equals(twoSumObj.twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2}));
        System.out.println(Arrays.equals(twoSumObj.twoSum(new int[]{3, 3}, 6), new int[]{0, 1}));
    }

}
