package string;

import java.util.Arrays;

public class ValidAnagrams {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        // s = "anagram", t = "nagaram"
        int[] s1 = new int[26];
        int[] s2 = new int[26];

        for(int i=0; i<s.length(); i++){
            s1[s.charAt(i) - 'a']++;
            s2[t.charAt(i) - 'a']++;
        }

        return Arrays.equals(s1, s2);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "car"));
    }
}
