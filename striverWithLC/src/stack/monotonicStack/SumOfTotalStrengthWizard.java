package stack.monotonicStack;


// LC - Hard
// really difficult to come up with a solution if seeing for first time.
// https://leetcode.com/problems/sum-of-total-strength-of-wizards/
// Writing this with seeing a video
// NOTE: Thought Process
// brute - for all subarrays compute mi and sum O(n2)

// VIdeo - https://www.youtube.com/watch?v=K31VME56L3o
// Video2 - sunny sum of total strength of wizards

// for smallest to left - use stack
// for smallest on right - use stack
// fix the min element and then find the sum of all the subarrays having that min elemtn
// eg - a[i] - min
// (l,, i,, r)
// For the sum from sum(l,i) = prefix(i+1) - prefix(i-l)
// you need to use double prefix here.

import java.util.Stack;

public class SumOfTotalStrengthWizard {
    public int totalStrength(int[] strength) {
        int n = strength.length;
        int MOD = 1_000_000_007;

        long[] preSum = new long[n+1];
        long[] prePrefix = new long[n+2];

        for (int i=0; i<n; i++){
            preSum[i+1] = (preSum[i] + strength[i]) % MOD;
        }

        // double prefix sum
        for(int i=0; i<=n; i++){
            prePrefix[i+1] = (prePrefix[i] + preSum[i]) % MOD;
        }

        // stores the element less than to left.
        int [] left = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i < strength.length; i++){
            while(!stack.isEmpty() && strength[i] <= strength[stack.peek()]){
                stack.pop();
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int[] right = new int[n];
        stack = new Stack<>();
        for( int i=strength.length - 1; i>=0; i--){
            while(!stack.isEmpty() && strength[i] < strength[stack.peek()]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long ans = 0;
        for(int i=0; i<n; i++){

            ans += ((prePrefix[right[i]+1] - prePrefix[i+1]) * (i - left[i]) % MOD + MOD -
                    (prePrefix[i+1] - prePrefix[left[i] +1]) * (right[i] - i) % MOD) * strength[i];
            ans %= MOD;
        }

        return (int)ans;
    }
}
