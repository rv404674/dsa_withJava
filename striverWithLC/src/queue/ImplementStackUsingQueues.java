package queue;

import java.util.LinkedList;
import java.util.Queue;

// NOTE: use a single queue. and whenever you insert.
// reverse it.
// https://leetcode.com/problems/implement-stack-using-queues/
class MyStack {
    Queue<Integer> queueBase;

    public MyStack() {
        this.queueBase=new LinkedList<Integer>();
    }

    public void push(int x) {
        queueBase.add(x);
        // now reverse it
        for(int i = 0; i<queueBase.size(); i++){
            queueBase.add(queueBase.poll());
        }

    }

    public int pop() {
        return queueBase.poll();
    }

    public int top() {
        return queueBase.peek();
    }

    public boolean empty() {
        return queueBase.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */


public class ImplementStackUsingQueues {
}
