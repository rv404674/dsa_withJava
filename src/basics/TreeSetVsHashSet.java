package basics;

import java.util.HashSet;
import java.util.TreeSet;

public class TreeSetVsHashSet {
    public static void main(String[] args) {
        // NOTE: Treeset based on TreeMapN
        // Treeset is used to maintain sorted ordering
        // but compare to HashSet - O(1) (add, remove, find) (based on Hashmap)
        // Treeset is O(logn) as it is based on Red black tree.

        HashSet<Integer> hashSet  = new HashSet<>();
        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(20);
        hashSet.add(40);

        for(int x:hashSet)
            System.out.println(x);

        // TreeSet
        // shown in sorted order.
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(10);
        treeSet.add(40);
        System.out.println("Printing treeset");
        for(int x:treeSet)
            System.out.println(x);
    }
}
