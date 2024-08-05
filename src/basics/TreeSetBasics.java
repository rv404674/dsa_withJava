package basics;

import java.util.TreeSet;

/**
 * Implemented using RBL (binary search tree).
 * Search, Delete, Get, Insertion - O(logn)
 *
 * Use - Instead of creating an array and then implementing binary search, use treeSet and its operations.
 */
public class TreeSetBasics {
    public static void main(String[] args) {
        // Sorted order.
        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(10);
        treeSet.add(25);
        treeSet.add(100);

        System.out.println(treeSet);

        // remove
        treeSet.remove(10);

        // check if element exists
        boolean containsSeven = treeSet.contains(7);

        System.out.println("Iterate");
        for(Integer a: treeSet){
            System.out.println(a);
        }

        int firstElement = treeSet.first();
        int lastElement = treeSet.last();

        // ceiling - returns smallest element in the subset of numbers >=x
        int ceilEle = treeSet.ceiling(20);
        // will return 25;


    }
}
