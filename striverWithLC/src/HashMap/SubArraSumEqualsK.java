package HashMap;

// Appraoch - See last solution
// https://leetcode.com/problems/subarray-sum-equals-k/discuss/803317/Java-Solution-with-Detailed-Explanation

// NOTE: Brute force
// O(n2)
// Optimized - O(n) (hashtable)
// NOTE: THought process, use a prefix array to keep track of sum and a hashmap to keep count of number of times you have seen it.
// Do multiple dry rungs

import java.util.HashMap;

public class SubArraSumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        prefixSum[0] = nums[0];
        for(int i=1; i<nums.length; i++)
            prefixSum[i] = prefixSum[i-1] + nums[i];
        // we have seen 0 1 times
        hashMap.put(0,1);
        int ans = 0, sum=0, x;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(hashMap.containsKey(sum-k)){
                ans += hashMap.get(sum-k);
            }

            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}
