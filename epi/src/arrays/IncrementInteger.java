package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IncrementInteger {

    // NOTE: given an array, increment it by 1
    // O(n) and O(n)
    public static int[] plusOneLeetCode(int[] digits) {
        int carry = 1;

        for (int i = digits.length -1 ; i>=0; i--){
            digits[i]= digits[i] + carry;
            if (digits[i] <= 9) {
                return digits;
            } else {
                digits[i] = 0;
            }

        }

        // by default in java any string is empty
        // and any array created has 0 elements.
        int[] tempFinal = new int[digits.length + 1];
        tempFinal[0] = 1;
        return tempFinal;
    }

    public static List<Integer> plusOne (List<Integer> A) {
        int carry = 1;
        Collections.reverse(A);

        for (int i=0; i<A.size(); i++){
            int x = carry + A.get(i);
            carry = x/10;
            A.set(i,x%10);
        }

        if(carry != 0){
            A.add(carry);
        }

        Collections.reverse(A);
        return A;
    }

    public static void main (String[] args){
        List<Integer> x = new ArrayList<>();
//        List<Integer> y = Arrays.asList(2,3,5);
        x.add(1);
        x.add(2);
        x.add(9);
//        System.out.println(plusOne(x));

        List<Integer> x2 = new ArrayList<>();
        x2.add(9);
        x2.add(9);
        x2.add(9);
        x2.add(9);
//        System.out.println(plusOne((x2)));

        int[] tempIc = {9,9,9,9};
        System.out.println(plusOneLeetCode(tempIc));


    }

}
