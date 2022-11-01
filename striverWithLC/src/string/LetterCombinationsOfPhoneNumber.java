package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    HashMap<Character, String> keysMap;

    public List<String> letterCombinations(String digits) {
        keysMap = new HashMap<>();
        keysMap.put('2',"abc");
        keysMap.put('3', "def");
        keysMap.put('4', "ghi");
        keysMap.put('5', "jkl");
        keysMap.put('6', "mno");
        keysMap.put('7', "pqrs");
        keysMap.put('8', "tuv");
        keysMap.put('9', "wxyz");


        List<String> ans = new ArrayList<>();
        dfs(digits, ans, "", 0);
        return ans;
    }

    public void dfs(String digits, List<String> ans, String cur, int index){
        // edge case
        if(digits.equals(""))
            return;

        if(index == digits.length())
        {
            ans.add(cur);
            return;
        }

        String values = keysMap.get(digits.charAt(index));
        for(Character s: values.toCharArray()){
            dfs(digits, ans, cur + s, index+1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber letterCombinationsOfPhoneNumber = new LetterCombinationsOfPhoneNumber();
        System.out.println(letterCombinationsOfPhoneNumber.letterCombinations(""));

        System.out.println(letterCombinationsOfPhoneNumber.letterCombinations("23"));

        System.out.println(letterCombinationsOfPhoneNumber.letterCombinations("2"));
    }
}
