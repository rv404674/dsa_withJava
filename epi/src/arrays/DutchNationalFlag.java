package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DutchNationalFlag {
    public static enum Color {
        RED, WHITE, BLUE
    }

    /**
     * NOTE: space - 3*O(n)
     * time - 3*O(n)
     */
    public static List<Color> dutchFlagPartitionAppr1(int pivotlndex, List<Color> A){
        Color pivot = A.get(pivotlndex);
        List<Color> lessThanPivot = new ArrayList<>();
        List<Color> equalToPivot = new ArrayList<>();
        List<Color> greaterThanPivot = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i).ordinal() < pivot.ordinal()) {
                lessThanPivot.add(A.get(i));
            } else if (A.get(i).ordinal() == pivot.ordinal()) {
                equalToPivot.add(A.get(i));
            } else {
                greaterThanPivot.add(A.get(i));
            }
        }

        // ArrayList add is O(1) amortized, but O(n) worst-case since the array must be resized and copied
        lessThanPivot.addAll(equalToPivot);
        lessThanPivot.addAll(greaterThanPivot);

        return lessThanPivot;
    }

    /**
     * NOTE: space - O(1)
     * time - O(n2)
     * The questions can be simply framed as thi as well
     * A = {0,1,1,0,2,0,0,1,0,0,2,1}
     * pivotIndex = 1
     */
    public static List<Color> dutchFlagPartitionAppr2(int pivotlndex, List<Color> A){
        Color pivot = A.get(pivotlndex);
        int i,j;

        // Approach use combination of (i,j) loops and place the smaller element at the first.
        for (i=0; i<A.size(); i++){
            for (j=i+1; j<A.size(); j++){
                if(A.get(j).ordinal() < pivot.ordinal()){
                    Collections.swap(A, i, j);
                    break;
                }
            }
        }

        // Approach use combination of (i,j) and move greater element at the end.
        for(i = A.size() -1; i>=0;i--){
            for(j = i-1; j>=0;j--){
                if(A.get(j).ordinal() > pivot.ordinal()){
                    Collections.swap(A, i,j);
                    break;
                }
            }
        }

        return A;
    }


    /**
     * NOTE: space - O(1)
     * time - 2*O(n)
     * The questions can be simply framed as thi as well
     * A = {0,1,1,0,2,0,0,1,0,0,2,1}
     * pivotIndex = 1
     */
    public static List<Color> dutchFlagPartitionAppr3(int pivotlndex, List<Color> A){
        // approach same things as above - just use smaller point and move to that point.
        Color pivot = A.get(pivotlndex);
        int smaller = 0;
        for(int i=0; i<A.size(); i++){
            if(A.get(i).ordinal() < pivot.ordinal() ){
                Collections.swap(A, i, smaller);
                smaller +=1;
            }
        }

        int larger = A.size() -1;
        for(int i = A.size()-1; i>=0;i--){
            if(A.get(i).ordinal() > pivot.ordinal()){
                Collections.swap(A, i, larger);
                larger -=1;
            }
        }

        return A;
        // do for greater elements now.
    }

    public static void main(String[] args) {
        // tc1
        List<Color> tcList1 = Arrays.asList(Color.WHITE, Color.RED, Color.WHITE, Color.WHITE, Color.BLUE, Color.RED, Color.WHITE, Color.BLUE);
        List<Color> tcAns1 = Arrays.asList(Color.RED, Color.RED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLUE, Color.BLUE);

        System.out.println(dutchFlagPartitionAppr1(2, tcList1));
        System.out.println(dutchFlagPartitionAppr2(2, tcList1));
        System.out.println(dutchFlagPartitionAppr3(2, tcList1));



    }

}
