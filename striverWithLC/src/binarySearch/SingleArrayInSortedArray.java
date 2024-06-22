package binarySearch;

// Appr1 : use hashtable
// TC - O(N+k), O(k)

// Appr2 - use one loop
// TC - O(N), O(1)

// Appr 3
// TC - use bin search. O(logn), O(1)
// NOTE: Though process
// pari index property
// [1,2,2,3,3]
// [0,1,2,3,4]
// if the answer is on left, (first unique - odd, second uniquq - even)

// [1,1,2,2,3]
// [0,1,2,3,4]
// if the answer is on the right, (first unique - even, second unique - odd)
// FInal solution - https://leetcode.com/problems/single-element-in-a-sorted-array/solutions/100754/java-binary-search-short-7l-o-log-n-w-explanations/comments/235525

public class SingleArrayInSortedArray {
    public static int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length-1 ;
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            if(mid%2 == 0){
                // ans to right
                if(nums[mid] == nums[mid+1])
                    lo = mid+2;
                else
                    hi = mid;
            } else {
                // for odd
                // {3,3,7,7,10,11,11}
                // ans to right
                if(nums[mid] == nums[mid-1]){
                    lo = mid+1;
                } else
                    hi = mid;
            }

        }

        return nums[lo];
    }

    public static void main(String[] args) {
        // 1 <= nums.length <= 105
        int[] tc2 = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(tc2));

        int[] tc1 = {1};
        System.out.println(singleNonDuplicate(tc1));

        int[] tc3 = {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(tc3));
    }
}
