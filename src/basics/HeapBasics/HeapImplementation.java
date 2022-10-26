package basics.HeapBasics;

import java.util.PriorityQueue;
import java.util.Queue;

public class HeapImplementation {
    // NOTE: INFO
    // Min Heap: value of node needs to <= to both left and right sub child.
    // Note: this needs to be valid across the whole tree.

    // Max Heap: Value of node needs to be >= to both left and right sub child.
    // if i = node
    // parent = (i-1)/2 index in an array
    // left = 2*i +1, right = 2*i+2

    // NOTE: UseCase
    // insert/delete = O(logn)
    // min/max in = O(1)
    // search = O(N)

    public static void main(String[] args) {
        // impelment min heap
        // use PQ
        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(100);
        minHeap.add(50);
        minHeap.add(1);

        System.out.println("min element" + minHeap.peek());
        minHeap.remove();
        System.out.println("min element" + minHeap.peek());

        // max Heap
        // (a,b) -> b - a
        // if a<b, b-a will be positive, means swap, i.e place b first.
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        maxHeap.add(20);
        maxHeap.add(400);
        maxHeap.add(900);
        System.out.println("max element" + maxHeap.peek());
        maxHeap.remove();
        System.out.println("max element" + maxHeap.peek());

        // for impelmentation using arrays
        // https://www.youtube.com/watch?v=ywx-Onrdx4U
    }
}
