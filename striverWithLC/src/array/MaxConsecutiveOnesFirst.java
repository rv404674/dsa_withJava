package array;

public class MaxConsecutiveOnesFirst {
    // Easy one
    // https://leetcode.com/problems/max-consecutive-ones/
    public int findMaxConsecutiveOnes(int[] nums) {
        // nums = [1,1,0,1,1,1]
        int mx = -1;
        int cnt = 0;
        for(int x: nums){
            if(x == 1)
                cnt +=1;
            else
                cnt = 0;
            mx = Math.max(mx, cnt);
        }

        return mx;
    }
}
