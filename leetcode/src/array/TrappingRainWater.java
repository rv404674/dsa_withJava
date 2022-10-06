package array;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class TrappingRainWater {

    /**
     * Requirements - Non Negative Numbers,  1<= n <= 10^4
     * UT - one in the example
     * and for n < 3, return 0, need atleast 3 towers to hold water
     *
     * NOTE: Approach 1
     * water = min(l_max, r_max) - height
     * for each index travel left get l_max and travel right get r_max.
     * O(n2)
     */
    public static int trapAppr1(int[] height) {
        if (height.length < 3)
            return 0;

        int water = 0;
        int curWater;
        // no water can be stored on first or last element
        for (int i = 1; i < height.length - 1; i++){
            int l_max = Integer.MIN_VALUE;
            int r_max = Integer.MIN_VALUE;

            // get l_max
            for (int p = 0; p < i; p++)
                l_max = max(l_max, height[p]);

            // get r_max
            for (int q = i+1; q < height.length; q++)
                r_max = max(r_max, height[q]);

            curWater = min(l_max, r_max) - height[i];
            water += curWater > 0 ? curWater : 0;
        }

        return water;
    }

    /**
     * NOTE: Approach2.
     * In approach 1, there are duplicate computations as you are again traversing same elements again and again.
     * Use an array to store l_max
     * then traverse from right end to left, and compute water
     *
     * time = 2*O(N), space = O(N)
     */
    public static int trapAppr2(int[] height) {
        if (height.length < 3)
            return 0;

        int[] lMaxArray = new int[height.length];
        lMaxArray[0] = height[0];

        for(int i=1; i<height.length; i++)
            lMaxArray[i] = max(lMaxArray[i-1], height[i-1]);

        int water = 0;
        int curWater;
        int rMax = height[height.length - 1];

        for(int i = height.length-2; i >=0; i--){
            curWater = min(lMaxArray[i], rMax) - height[i];
            water += curWater > 0 ? curWater : 0;

            rMax = max(rMax, height[i]);
        }

        return water;
    }

    /**
     * NOTE: Approach3. Most optimized
     * Two Pointer
     * Striver - https://www.youtube.com/watch?v=m18Hntz4go8
     * Approach - You need only one lMax check. not both.
     * time = O(N), space = O(1)
     */
    public static int trapAppr3(int[] height) {
        if(height.length < 3)
            return 0;

        int lMax = 0, rMax = 0, l=0, r = height.length - 1;
        int totalWater = 0;

        while (l <= r){
            if(height[l] <= height[r]) {
                if(height[l] > lMax) {
                    lMax = height[l];
                } else {
                    // Check the video to see why we are not taking rMax into consideration.
                    //  HINT: it is because of if(height[l] <= height[r]) check.
                    totalWater += lMax - height[l];
                }
                l++;
            } else {
                if(height[r] > rMax)  {
                    rMax = height[r];
                } else {
                    totalWater += rMax - height[r];
                }

                r--;
            }
        }

        return totalWater;

    }


    public static void main(String[] args) {
        System.out.println(trapAppr3(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trapAppr3(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
