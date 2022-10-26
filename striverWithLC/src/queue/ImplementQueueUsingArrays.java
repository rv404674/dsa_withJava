package queue;

// NOTE: Queue is a FIFO
// use two pts, front and rear to track insertion and deletion
// insertion from rear
// deletion from front.
class QueueBasics {
    int front = 0, rear = 0;
    int mxSize = 1000;
    int curSize = 0;
    int[] a = new int[mxSize];

    public void push(int x){
        if(curSize == mxSize){
            System.out.println("Queue is Full");
            return ;
        }

        a[rear] = x;
        rear +=1;
        curSize +=1;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Queue is already empty");
            return -1;
        }

        int x = a[front];
        front +=1;
        curSize -=1;

        return x;
    }

    public int top() {
        return a[front];
    }

    public int size() {
        return curSize;
    }

    boolean isEmpty() {
        return (front == rear);
    }
}

public class ImplementQueueUsingArrays {
    public static void main(String[] args) {
        QueueBasics q = new QueueBasics();
        System.out.println(q.pop());
        q.push(10);
        q.push(20);
        q.push(30);
        System.out.println(q.pop());
        System.out.println(q.curSize);


    }
}
