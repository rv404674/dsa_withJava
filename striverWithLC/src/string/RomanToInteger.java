package string;

import java.util.HashMap;

public class RomanToInteger {

    // SC - O(K) for HM
    // TC - O(n^2) becasue os subtring
    public static int romanToInt(String s) {
        HashMap<String , Integer> hashMap = new HashMap<>();
        hashMap.put("I", 1);
        hashMap.put("V", 5);
        hashMap.put("X", 10);
        hashMap.put("L", 50);
        hashMap.put("C", 100);
        hashMap.put("D", 500);
        hashMap.put("M", 1000);
        hashMap.put("IV", 4);
        hashMap.put("IX", 9);
        hashMap.put("XL", 40);
        hashMap.put("XC", 90);
        hashMap.put("CD", 400);
        hashMap.put("CM", 900);

        int i=0;
        int sum = 0;
        while(i < s.length()){
            String s1 = s.substring(i, i+1);
            String s2 = "";
            if(i+1 < s.length())
                s2 = s.substring(i, i+2);

            if(hashMap.containsKey(s2)){
                i+=2;
                sum += hashMap.get(s2);
            } else {
                i+=1;
                sum += hashMap.get(s1);
            }
        }

        return sum;
    }


    public static int romanToIntApproach2(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int ans = 0;
        for(int i = s.length() - 1; i>=0; i--){
            int val = hashMap.get(s.charAt(i));
            if(val * 4 < ans){
                ans -= val;
            } else {
                ans +=val;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(romanToIntApproach2("LVIII"));
        System.out.println(romanToIntApproach2("MCMXCIV"));
        System.out.println(romanToIntApproach2("III"));
    }


}
