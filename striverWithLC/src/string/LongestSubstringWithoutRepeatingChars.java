package string;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChars {
    // Appr1: bruteforc O(n3)

    // Appr2: Optimized
    // sliding window + hashset
    // keep moving left and right, and add it to the hashset.
    // track hashset ans as len.
    // TC - O(2*n), SC - O(n)
    // NOTE: Thought process you need to maintain the invariant
    // keep a substring that has uniqqueness, how do you maintain that uniqueness now?
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int left=0, right = 0;
        int ans = -1;

        while(right < s.length()){
            if(hashSet.contains(s.charAt(right))){
                // duplicate found
                // move left
                while(s.charAt(left) != s.charAt(right)) {
                    hashSet.remove(s.charAt(left));
                    left +=1;
                }

                // remove it because will be adding it again.
                hashSet.remove(s.charAt(left));
                left +=1;
            }

            hashSet.add(s.charAt(right));
            ans = Math.max(ans, hashSet.size());
            right++;
        }

        ans = Math.max(ans, hashSet.size());
        return ans;
    }

    // O(n), O(n)
    // instead of traversing the whole string, just start from left+1.
    public static int lengthOfLongestSubstringAppr3(String s) {
        if (s.length() <= 1)
            return s.length();

        int res = 0;
        int l = 0, r = 0;

        HashMap<Character, Integer> hashMap = new HashMap<>();

        while (r < s.length()) {
            if (hashMap.containsKey(s.charAt(r))) {
                // process l and increment it
                int curPos = hashMap.get(s.charAt(r));
                if (curPos >= l && curPos <= r)
                    l = curPos + 1;
            }

            hashMap.put(s.charAt(r), r);
            res = Math.max(res, r - l + 1);
            r += 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(LongestSubstringWithoutRepeatingChars.lengthOfLongestSubstring(""));
        System.out.println(LongestSubstringWithoutRepeatingChars.lengthOfLongestSubstring("a"));
        System.out.println(LongestSubstringWithoutRepeatingChars.lengthOfLongestSubstring("abcd"));
        System.out.println(LongestSubstringWithoutRepeatingChars.lengthOfLongestSubstring("aaaa"));
        System.out.println(LongestSubstringWithoutRepeatingChars.lengthOfLongestSubstring("abacdefdhijq"));
    }
}
