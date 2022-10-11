package hashMap;

import java.util.HashMap;
import java.util.Map;

public class romanToInteger {
    public static int romanToIntAppr1(String s) {
        // MapOf key1, val1
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("I", 1);
        hashMap.put("V" ,5);
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

        int sum =0;
        int i = 0;

        while(i+1<s.length()){
            String subString = s.substring(i, i+2);
            if(hashMap.containsKey(subString)) {
                sum += hashMap.get(subString);
                 i += 2;
            } else {
                sum += hashMap.get(s.substring(i, i+1));
                i+=1;
            }
        }

        if(i<s.length())
            sum+= hashMap.get(s.substring(i,i+1));

        return sum;
    }

    /**
     * NOTE: preprocess the string, and remove the edge cases.
     * time - 7*O(N), space - O(5)
     */
    public static int romanToIntAppr2(String s) {
        // MapOf key1, val1
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V' ,5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int sum =0;
        int i = 0;

        s = s.replaceAll("IV", "IIII")
                .replaceAll("IX", "VIIII")
                .replaceAll("XL", "XXXX")
                .replaceAll("XC", "LXXXX")
                .replaceAll("CD", "CCCC")
                .replaceAll("CM", "DCCCC");

        for(char c: s.toCharArray()){
            sum += hashMap.get(c);
        }

        return sum;
    }

    /**
     * Most optimized, process from right to left. and use this pattern
     * if IV, IX and result >=5 subtract I, else add I
     * if XL, XC and result >= 50, subtract X else add X
     * if CD, CM and result >=500, subtract C else add C
     */
    public static int romanToIntAppr3(String s) {
        // MapOf key1, val1
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V' ,5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int result =0;
        for (int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == 'I') {
                result += (result >= 5? -1 : 1);
            } else if(s.charAt(i) == 'X') {
                result += (result >= 50? -10: 10);
            } else if(s.charAt(i) == 'C') {
                result += (result >= 500? -100: 100);
            } else {
                result += hashMap.get(s.charAt(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToIntAppr3("MCMXCIV"));
        System.out.println(romanToIntAppr3("LVIII"));
    }

}
