package collectionbasics;

import java.util.Arrays;

public class References {
    public static void main(String[] args){
        // NOTE: References
        int[] a1 = {1,2,3};
        int[] a2 = {1,2,3};

        System.out.println(a1);
        System.out.println(a2);

        // This is checking Reference, basically it is checking mem address, hence it will yield false.
        System.out.println(a1 == a2);

        // to compare values.
        System.out.println(Arrays.equals(a1, a2));

        Integer n = 10;
        int n2 = 10;

        // NOTE:
        // All Primitive types in Java will have a wrapper class.
        // int -> Integer
        // long -> Long
        // Primitives types are fast, but most of collections in java operate on objects, hence these wrapper classes
        // are required.

        Integer.parseInt("901");
    }
}
