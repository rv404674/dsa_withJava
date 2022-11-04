package string;

import array.LongestPalindromeSubstring;

public class LongestPalindromincSubString {
    /**
     * Brute Force: O(n^3), brute force.
     * NOTE: more optimized O(n2),
     * Nick white video
     * take an index and try expanding from that
     * Problem - https://leetcode.com/problems/longest-palindromic-substring/submissions/
     */
    public String longestPalindrome(String s) {
        int mx = -1;
        int start = 0, end = 0;
        for(int i=0; i<s.length(); i++){
            // case1 racecar
            int l1 = expandFromMiddle(s, i, i);
            int l2 = expandFromMiddle(s, i, i+1);
            int l = Math.max(l1, l2);
            if (l>mx){
                mx = l;
                // "cbbd"
                // "racecar"
                start = i - ((l-1)/2);
                end = i + l/2;
            }
        }

        // ending is exclusive
        return s.substring(start, end + 1);

    }

    public int expandFromMiddle(String s, int i, int j){
        if(s.isEmpty())
            return 0;

        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            i-=1;
            j+=1;
        }

        // dry run to figure this out.
        return (j-i-1);
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring longestPalindromeSubstring = new LongestPalindromeSubstring();
        System.out.println(longestPalindromeSubstring.longestPalindrome("axybaabyyyyba"));
    }
}
