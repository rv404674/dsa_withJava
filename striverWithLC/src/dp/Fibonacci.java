package dp;

import java.util.Arrays;

// TC - O(n)
// SC - O(N) (recursoin stack) + O(N) for array
public class Fibonacci {
    public int fibAppr1(int n) {
        if(n<=1)
            return n;

        int[] dpArray = new int[n+1];
        Arrays.fill(dpArray, -1);

        fibUtil(n, dpArray);
        return dpArray[n];
    }

    public int fibUtil(int n, int[] dpArray){
        if(n<=1)
            return n;
        if(dpArray[n] != -1)
            return dpArray[n];

        dpArray[n] = fibUtil(n-1, dpArray) + fibUtil(n-2, dpArray);
        return dpArray[n];
    }

    // TC - O(N), SC - O(N)
    // NOTE: Tabulation, use bottoms up appraoch.
    // base case to required.
    // will always be better than recursion + memoizatoin as there will be no stack space required.
    public int fibAppr2(int n) {
        if(n<=1)
            return n;

        int[] dpArray = new int[n+1];
        dpArray[0] = 0;
        dpArray[1] = 1;
        for(int i=2; i<=n;i++)
            dpArray[i] = dpArray[i-1] + dpArray[i-2];
        return dpArray[n];
    }

}
