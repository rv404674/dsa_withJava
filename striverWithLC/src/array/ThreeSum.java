package array;

import java.util.*;

public class ThreeSum {
    // NOTE: Requirements triplets should be unique, and order of o/p doesnt matter

    /**
     * Appr1 - 3 loops (checking i,j and k)
     * put in a hashset(x,y,z) for handling duplicatoion
     * TC - O(n^3), SC - O(n)
     *
     * Appr2 - sort and do the above
     * TC - O(nlogn) + O(n^2logn), SC - O(n)
     *
     * Appr3 - sort and use two pointer approach
     * TC - O(nlogn) + O(n2), SC - O(N)
     */

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> hashSet = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i<nums.length -1; i++){
            int p = i+1;
            int q = nums.length -1;

            while(p<q){
                int x = nums[i] + nums[p] + nums[q];
                if(x == 0){
                    hashSet.add(List.of(nums[i], nums[p], nums[q]));
                    p+=1;
                    q-=1;
                } else if(x < 0)
                    p = p+1;
                else
                    q = q-1;
            }
        }

        Iterator iterator = hashSet.iterator();
        while(iterator.hasNext()){
            List<Integer> tmp = (List<Integer>) iterator.next();
            result.add(tmp);
        }

        return result;
        // or
        // return new ArrayList<>(hashSet);
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum.threeSum(new int[]{0,1,3,4,5,-1,-2,-3,-4}));
    }
}
