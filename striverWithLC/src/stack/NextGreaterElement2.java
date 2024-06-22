package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    // LC Medium
    // Saw Striver's solution - https://www.youtube.com/watch?v=Du881K7Jtk8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=76
    // Brute Force - O(n^2)
    // NOTE: Optimized solution
    // Part1: Dont consider the circular array. consider it to be 1d.
    // NOTE: for part1, start from rightmost and use the stack to keep track of max element.

    // Part2: then consider the circular array.
    // for part2, use the above approach, just keep a copy of above array on the right.
    // for(int i = 2*nums.length -1; i>=0; i--)
    // and then
    // replace i with i%n.

    // NOTE: dummy run on these test cases
    // you will get the flow
    // [4,12,5,3,1,2,5,3,1,2,4,6]
    // [9,10,1,5,7,20,30,1,90]

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] nGE = new int[nums.length];
        int n = nums.length;
        int x;

        for(int i = 2*nums.length -1; i>=0; i--){
            // if stack's top is less, pop it
            while(!stack.empty() && nums[i%n]>=stack.peek())
                stack.pop();

            if(stack.empty()){
                x = -1;
            } else {
                x = stack.peek();
            }

            nGE[i%n] = x;
            stack.push(nums[i%n]);
        }

        return nGE;
    }

    public static void main(String[] args) {
        int[] tc1 = new int[]{2,10,12,1,11};
        System.out.println(Arrays.toString(nextGreaterElements(tc1)));

        int[] tc2 = new int[]{10};
        System.out.println(Arrays.toString(nextGreaterElements(tc2)));

    }
}
