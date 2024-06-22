package stack.monotonicStack;

import java.util.Stack;

// Problem - https://leetcode.com/problems/daily-temperatures/
public class DailyTemperature {
    // Naive - O(N^2), two loops
    // Optimized - O(n*2)
    // Monotonic decreasing stack
    // NOTE: dont remember which stack to use
    // THought Process: the next element you encounter if it is greater then stack's peek, bingo, you got the answer.
    // NOTE: Dry run on this temperatures = [73,74,75,71,69,72,76,73]
    // TC - O(2n) (every element is pushed and removed max 2 times)
    // SC - O(n)

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        // by default it will have 0 as values
        int[] ans = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                // you got a bigger element
                int x = stack.pop();
                ans[x] = i-x;
            }

            stack.add(i);
        }

        return ans;
    }


}
