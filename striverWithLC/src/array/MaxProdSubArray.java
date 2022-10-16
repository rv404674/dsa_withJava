package array;

public class MaxProdSubArray {
    /**
     * Appr1
     * Bruteforce. Use two loops - O(n2).
     *
     * Appr2 - O(n)
     * keep a track of maxn and min at each step.
     * video - https://www.youtube.com/watch?v=tHNsZHXnYd4
     */
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int mn = nums[0];
        int mx = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i]<0)
            {
                // swap both of them
                // if the current number if -ve.
                // it makes sense to swap mx with mi.
                // as -ve * -smallest num will be a very big number.
                int x = mn;
                mn = mx;
                mx = x;
            }

            mx = Math.max(nums[i], nums[i]*mx);
            mn = Math.min(nums[i], nums[i]*mn);

            result = Math.max(mx, result);
        }

        return result;
    }

    public static void main(String[] args) {
        MaxProdSubArray maxProdSubArray = new MaxProdSubArray();
        System.out.println(maxProdSubArray.maxProduct(new int[]{2,3,7,-1,-2,-1,20,30,40}));
    }

}
