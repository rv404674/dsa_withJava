package stack;

// CodingNinja - https://www.codingninjas.com/codestudio/problems/stack-implementation-using-array_3210209
// Use Array, simple array

// Constrainsts - N<=10^3
class stack {
    int size = 1000;
    int[] a = new int[size];
    int top = -1;

    void push(int num) {
        // Write your code here.
        top+=1;
        a[top] = num;
    }

    int pop() {
        // NOTE: you dont actually need to delete anything.
        int x = a[top];
        top -=1;
        return x;
    }

    int top() {
        return a[top];
    }

    boolean isEmpty() {
        return (top == -1);
    }

    int size() {
        return top+1;
    }

}
public class ImplementStackUsingArrays {
    public static void main(String[] args) {
        stack s = new stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.top());
        System.out.println(s.size());
        System.out.println(s.pop());
        System.out.println(s.top());

    }

}


