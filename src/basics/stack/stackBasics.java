package basics.stack;

import java.util.Stack;

public class stackBasics {
    public static void main(String[] args) {
        // Stack is a LIFO DS.
        // last in first out.

        Stack<Integer> stack = new Stack<>();
        // operations
        // push - push to stack
        // peek - return the top element without popping
        // pop() - return the top element with popping
        // empty() - check for empty stack

        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println("Initial stack:" + stack);

        // top element
        System.out.println(stack.peek());
        System.out.println(stack.empty());

        int topElement = stack.pop();
        System.out.println(topElement);
        System.out.println(stack);
    }
}
