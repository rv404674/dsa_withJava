package hashMap;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Appr1: O(n^3) generate all substrings and then check if a string has unique chars.
 * if it does then store the len.
 *
 * TC, SC = O(n), O(n)
 *
 * Appr2:
 * Sliding window + Hash Map
 * use l,r
 * keep moving r to right and when you encounter a duplicate, move l to the duplicate's character + 1.
 * https://www.youtube.com/watch?v=qtVh-XEpsJo
 * TC, SC = O(n), O(n)
 */

public class LongestSubstringWithoutRepeatingChars {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();

        int res = 0;
        int l = 0, r=0;

        HashMap<Character, Integer> hashMap = new HashMap<>();

        while(r < s.length()){
            if(hashMap.containsKey(s.charAt(r))) {
                // process l and increment it
                int curPos = hashMap.get(s.charAt(r));
                if(curPos >= l && curPos <=r)
                    l = curPos + 1;
            }

            hashMap.put(s.charAt(r), r);
            res = Math.max(res, r-l+1);
            r +=1;
        }

        return res;
}

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcaabcdba"));
        System.out.println(lengthOfLongestSubstring("abccbadbb"));
    }
}
