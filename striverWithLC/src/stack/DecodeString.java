package stack;

import java.util.Stack;

// LC Med
// Solution - https://leetcode.com/problems/decode-string/discuss/87570/Simple-1-pass-Java-Solution-with-only-1-stack-with-explanation


public class DecodeString {
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char i : s.toCharArray()) {
            if (i != ']')
                stack.push(i);
            else {
                String temp1 = "";
                while(!stack.isEmpty() && stack.peek() != '[')
                    temp1 = stack.pop() + temp1;

                // got a [
                stack.pop();

                // got a number
                // "100[leetcode]"
                String number = "";
                while(!stack.isEmpty() && Character.isDigit(stack.peek()))
                    number = stack.pop() + number;

                int count = Integer.parseInt(number);
                while(count > 0){
                    for(char x: temp1.toCharArray())
                        stack.push(x);
                    count --;
                }
            }
        }

        String ans = "";
        while (!stack.isEmpty())
            ans = stack.pop() + ans;
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(DecodeString.decodeString("3[a2[c]]"));
        System.out.println(DecodeString.decodeString("3[a]2[bc]"));
        System.out.println(DecodeString.decodeString("2[abc]3[cd]ef"));
        System.out.println(DecodeString.decodeString("100[leetcode]"));


    }
}
