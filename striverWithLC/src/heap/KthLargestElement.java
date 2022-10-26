package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class KthLargestElement {
    // O(nlogn)
    public static int findKthLargestAppr1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // NOTE: Using Heap
    // heap will be better if we had q queries to find max.
    // TC: O(nlogk) (at any pt heap is of size k)
    // SC: O(k)
    // for largest elements use min heap (as you can eject smallest elements)
    public static int findKthLargestAppr2(int[] nums, int k) {
        // max heap
        Queue<Integer> maxHeap = new PriorityQueue<>();
        for(int x: nums) {
            maxHeap.add(x);
            if(maxHeap.size() > k){
                maxHeap.remove();
            }
        }

        return maxHeap.peek();
    }

    // NOTE: most optimized one
    // O(N)
    // Use quick select algo
    // understang this
    // https://www.youtube.com/watch?v=hGK_5n81drs&t=634s
    // TC = T(n/2) + n-1
    public static int findKthLargestAppr3(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        Random rand = new Random(0);

        while(left <= right){
            // rand.nextInt is [0, pivotIndex)
            int pivotIndex = rand.nextInt(right - left + 1) + left;
            int finalPivotIndex = partition(nums, pivotIndex, left, right);

            if(finalPivotIndex == (n-k)){
                return nums[finalPivotIndex];
            } else if(finalPivotIndex > (n-k)){
                right = finalPivotIndex -1;
            } else {
                left = finalPivotIndex +1;
            }
        }

        return -1;

    }

    public static int partition(int[] nums, int pivotIndex, int left, int right){
        int pivot = nums[pivotIndex];
        // swap pivotIndex with right to keep pivot safe at right index.
        swap(nums, pivotIndex, right);
        // NOTE: pivotTail will keep track of the elements less than pivotIndex.
        int pivotTail = left;
        for(int i=left; i<right; i++){
            if(nums[i] < pivot){
                swap(nums, pivotTail, i);
                pivotTail +=1;
            }
        }

        swap(nums, pivotTail, right);
        return pivotTail;

    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }




        public static void main(String[] args) {

    }
}
