package array;

import java.util.Arrays;

public class NextPermutation {
    // TC - O(N), SC - O(1)

    public void nextPermutation(int[] nums) {
        // TODO: handle all desc case later
        if (nums.length <= 1)
            return;

        // find the first id that breaks the desending order
        int i = nums.length - 2;
        while(i>=0 && nums[i] >= nums[i+1])
            i-=1;

        // find x = the element greater than nums[i] in right side
        // x will be swapped by i then
        if (i >= 0) {
            int j = nums.length-1;
            while(nums[j] <= nums[i])
                j-=1;

            swap(nums, i, j);
        }

        // will automatically handle the [3,2,1] condition.
        reverseAll(nums, i+1, nums.length-1);
    }

    void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    void reverseAll(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start +=1;
            end -=1;
        }
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] a = {2,3,1};
        nextPermutation.nextPermutation(a);
        System.out.println(Arrays.toString(a));

        int[] a2 = {7,9,8,5,7,6};
        nextPermutation.nextPermutation(a2);
        System.out.println(Arrays.toString(a2));

        int[] a3 = {3,2,1};
        nextPermutation.nextPermutation(a3);
        System.out.println(Arrays.toString(a3));

    }

}
