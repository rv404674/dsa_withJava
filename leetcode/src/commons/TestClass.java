package commons;

import array.TwoSum;

import java.util.Arrays;

public class TestClass {
    public static void main(String[] args){
        System.out.println("Hello World");
    }

    // Test Arrays
    public static void testArrays(){
        TwoSum twoSumObj = new TwoSum();

        System.out.println(Arrays.equals(twoSumObj.twoSum(new int[]{2, 7, 9, 11}, 9), new int[]{0, 1}));
        System.out.println(Arrays.equals(twoSumObj.twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2}));
        System.out.println(Arrays.equals(twoSumObj.twoSum(new int[]{3, 3}, 6), new int[]{0, 1}));
    }

}
