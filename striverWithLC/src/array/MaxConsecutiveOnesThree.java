package array;

public class MaxConsecutiveOnesThree {
    // Prob - https://leetcode.com/problems/max-consecutive-ones-iii/
    // Two Pointer approach
    // TC - 2*O(N), SC - O(1)
    // ACCEPTED
    // SOlution - https://www.youtube.com/watch?v=Gl-8HLvV8bc
    // easy to understand
    public static int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int ans = Integer.MIN_VALUE;
        int zeroCount = 0;

        while (right < nums.length) {
            // if encounter 1, do nothign just increment right
            if (nums[right] == 0) {
                // encounter 0 -> increment
                zeroCount += 1;
                while (zeroCount > k) {
                    if (nums[left] == 0)
                        zeroCount -= 1;
                    left += 1;
                }
            }

            // length of a window will be right-left +1
            ans = Math.max(ans, right - left + 1);
            // right will always increase
            right += 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes(a, k));
    }
}
