package heap;

// Appr1: every time you add sort the aarray.
// add() - O(nlogn)
// get() - O(1)

// Appr2: keep the list sorted
// add() - O(logn) + O(n) (for insertion)
// get() - O(1)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class MedianFinder {
    List<Integer> dataStream;

    public MedianFinder() {
        dataStream = new ArrayList<>();
    }

    public void addNum(int num) {
        // find the position to insert the num
        if(dataStream.isEmpty()){
            dataStream.add(num);
        } else {
            int index = binSearch(num);
            if (index == dataStream.size())
                dataStream.add(num);
            else
                dataStream.add(index, num);
        }
    }

    public double findMedian() {
        int len = dataStream.size();
        if(len %2 == 0){
            // even
            // correcting the zero based positioning.
            double x = (dataStream.get(len/2 - 1) + dataStream.get(len/2))/2.0;
            return x;
        } else {
            return dataStream.get((len+1)/2 - 1);
        }
    }

    // this will find the insertio index
    // [0], one more zero to be inserted
    // [1,2] -> 3 to be inserted
    // [1,5,7,10,15,20] -> 9 to be inserted
    // NOTE: use your brain a bit, try diff permutations and combination
    public int binSearch(int x){
        int lo = 0;
        int hi = dataStream.size() - 1;
        while (lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(dataStream.get(mid) >= x) {
                // now you dont need to do +1, and it will handle every case.
                hi = mid -1;
            } else {
                lo = mid +1;
            }
        }
        return lo;
    }



}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// Approach 3 - Heap
// dry using this  - https://www.youtube.com/watch?v=itmhHWaHupI
// NOTE: we had already achieved O(N) for addNum()
// less than that is O(logn) -> Heap
// two heaps will be used small heap (max heap) and large heap (min heap)
// NOTE: There will be two variants
// NOTE: 1. all elements in small heap will be <= all elements in large heap
// (1,2) (3,4)
// that is why small heap is a max heap (as for median you will require its biggest element)
// NOTE: 2. size of both heaps should be approx equal. (2,2) (2,3) cant be (2,4)

// eg 3,2,7,4
class MedianFinder2 {
    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> largeHeap;

    public MedianFinder2() {
        smallHeap = new PriorityQueue<>((a,b) -> (b-a));
        largeHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // by default add to smallHeap
        smallHeap.add(num);

        // variant 1: all elements in smallHeap < all elements in largeHeap
        if(!smallHeap.isEmpty() && !largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek()){
            int x = smallHeap.remove();
            largeHeap.add(x);
        }

        // variant 2: check for size
        if(largeHeap.size() > smallHeap.size() + 1){
            int x= largeHeap.remove();
            smallHeap.add(x);
        }

        if(smallHeap.size() > largeHeap.size() + 1){
            int x = smallHeap.remove();
            largeHeap.add(x);
        }
    }

    public double findMedian() {
        // if smallHeap has 3 elements and largHeap has 2 elements
        if(smallHeap.size() > largeHeap.size())
            return smallHeap.peek();
        else if (smallHeap.size() < largeHeap.size())
            return largeHeap.peek();
        else
            return (smallHeap.peek() + largeHeap.peek()) /2.0;
            // if equal
    }

}



public class FindMedFromDataStream {
    // this will find the insertio index
    // [0], one more zero to be inserted
    // [1,2] -> 3 to be inserted
    // [1,5,7,10,15,20] -> 9 to be inserted
    public static int binSearch(List<Integer> dataStream, int x){
        int lo = 0;
        int hi = dataStream.size() - 1;
        while (lo <hi){
            int mid = dataStream.get( (hi-lo)/2 + lo);
            if(dataStream.get(mid) == x) {
                return mid+1;
            } else if(dataStream.get(mid) < x) {
                lo = mid +1;
            } else {
                hi = mid -1;
            }
        }

        if(dataStream.get(lo) >= x) {
            // if x is less than first element
            // x = 1 [2,3,4,5]
            return lo;
        } else {
            // if x is greater then last element
            // x = 10
            // [1,2,3,4]
            return lo+1;
        }

    }

    public static void main(String[] args) {

    }
}
