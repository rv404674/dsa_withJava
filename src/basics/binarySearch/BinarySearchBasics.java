package basics.binarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchBasics {
    // best, worst, average = O(logn)
    // assumes the array is alredy sorted.
    boolean binarySearch(List<Integer> a, int x){
        if(a.isEmpty())
            return false;

        int lo = 0, hi = a.size()-1;
        while(lo <= hi){
            // we could have also done (lo+hi)/2.
            // bt we didn't do that because of integer overflow.
            int cur = lo + (hi-lo)/2;
            if(a.get(cur) == x)
                return true;
            if(a.get(cur)<x)
                lo = cur+1;
            else
                hi = cur-1;
        }

        return false;

    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1,5,7,10,15,20);
        BinarySearchBasics binarySearchBasics = new BinarySearchBasics();
        System.out.println(binarySearchBasics.binarySearch(a, 15));

        // returns index of the key if contained
        System.out.println(Collections.binarySearch(a, 20));
        // return (-(index)-1), if the key is not there
        System.out.println(Collections.binarySearch(a, 30));
    }
}
