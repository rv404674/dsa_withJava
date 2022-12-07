package HashMap;

// PS - https://leetcode.com/problems/longest-consecutive-sequence/
// not your dp LCS

import java.util.HashMap;
// BRute - sort - O(nlogn)
public class LongestConsecutiveSubsequence {
    public static int longestConsecutive(int[] nums) {
        if(nums.length <= 1)
            return nums.length;

        int mxLen = Integer.MIN_VALUE;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i: nums)
            hashMap.put(i, 1);

        for(int i: nums){
            int cur = i + 1;
            while(hashMap.containsKey(cur) && hashMap.get(cur) == 1){
                // this is done to prevernt further visists
                // [5,6,7,8,9,10]
                hashMap.put(cur, 0);
                cur = cur +1;
            }

            mxLen = Math.max(mxLen, cur - i);
        }

        return mxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(longestConsecutive(new int[]{1}));
        System.out.println(longestConsecutive(new int[]{}));
        System.out.println(longestConsecutive(new int[]{1,1,1}));
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longestConsecutive(new int[]{2,5,10,20,30,6,7,8,9}));
    }


}
