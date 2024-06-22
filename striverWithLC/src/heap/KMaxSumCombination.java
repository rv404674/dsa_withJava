package heap;

import java.util.* ;
import java.io.*;

public class KMaxSumCombination {
    // NOTE: Appr1 sorting
    // TC = O(N^2) + O(k)
    // SC = O(N^2) (for the whole array) + O(K) (for answer)

    // NOTE: Appr2 maxheap
    // TC = O(N^2 lgK) + klog(k) (final peek)
    // SC = O(K) + O(K)
    // n<=100
    // Problem link - https://www.codingninjas.com/codestudio/problems/k-max-sum-combinations_975322?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
    public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k){
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        // minHeap
        Queue<Integer> minHeap = new PriorityQueue<>();

        for(int x: a){
            for (int y: b){
                minHeap.add(x + y);

                if(minHeap.size() > k)
                    minHeap.remove();
            }
        }

        while(!minHeap.isEmpty()){
            ans.add(minHeap.remove());
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(5);

        ArrayList<Integer> b = new ArrayList<>();
        b.add(6);
        b.add(4);
        b.add(2);

        kMaxSumCombination(a, b, 3, 2);

    }
}
