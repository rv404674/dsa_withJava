package array.twoPointer;

// Appr1 : BruteForce (n^n)

// NOTE: Appr2: Optimized - Two pointer - O(N)
// start with left = 0, right = n-1;
// move the one of the above that is the small.
// NOTE: Think if left is small, even if you move right to left, area will decrease not increase
// CRUX: area is dependent on the smaller side.

// AC in 25mins.

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int ans = -1;
        int n = height.length;
        int left = 0, right = n-1;

        while(left < n && right >=0){
            ans = Math.max(ans, Math.min(height[left], height[right]) * (right-left));

            if(height[left] <= height[right]){
                left +=1;
            } else {
                right -=1;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{1,1}));
        System.out.println(maxArea(new int[]{1,5}));
        System.out.println(maxArea(new int[]{7,8,19,4}));
    }
}
