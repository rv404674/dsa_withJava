package stack;

import java.util.Stack;

class StackObject {
    char value;
    int count;

    public StackObject(char value, int count) {
        this.value = value;
        this.count = count;
    }
}

public class RemoveAllAdjacentDuplicatesInString {

    // s = "deeedbbcccbdaa", k = 3
    // ThoughtProcess
    // Use stack to store (char, count).
    // whenvever the total count reaches K, delete
    // at the end get all stack elements and return.
    // TC - O(2n), SC - O(n)
    public static String removeDuplicates(String s, int k) {
        Stack<StackObject> stack = new Stack();
        StringBuilder stringBuilder = new StringBuilder();

        for(char c: s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(new StackObject(c, 1));
            } else {
                StackObject prev = stack.peek();
                if(prev.value == c){
                    if(prev.count +1 == k){
                        while(!stack.empty() && stack.peek().value == c)
                            stack.pop();
                    } else {
                        stack.push(new StackObject(c, prev.count+1));
                    }
                } else {
                    stack.push(new StackObject(c, 1));
                }
            }
        }

        while(!stack.empty()){
            stringBuilder.append(stack.pop().value);
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abcd",2));
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
    }
}
