package dp;

import java.util.Arrays;

public class LCS {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] a: dp)
            Arrays.fill(a, -1);

        return recurse(n-1, m-1, text1, text2, dp);
    }

    public int recurse(int n, int m, String text1, String text2, int[][] dp){
        if(n<0 || m<0)
            return 0;

        if(dp[n][m] != -1)
            return dp[n][m];

        if(text1.charAt(n) == text2.charAt(m)) {
            dp[n][m] = 1 + recurse(n - 1, m - 1, text1, text2, dp);
        }
        else {
            dp[n][m] = Math.max(recurse(n, m - 1, text1, text2, dp), recurse(n - 1, m, text1, text2, dp));
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";

        LCS lcs = new LCS();
        System.out.println(lcs.longestCommonSubsequence(s1, s2));
    }
}
