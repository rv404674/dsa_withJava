package basics;

import java.util.Arrays;

public class ArraysBasics {
    public void int2DArray(){
        int[][] intArray = new int[3][3];

        int[][] int2 = {{1,2,3}, {4,5,6}};
        int[][] int3 = {{7,8,9}, {10,11,12}};

        for(int i=0; i<int2.length; i++)
            for(int j=0; j<int2[0].length; j++)
                intArray[i][j] = int2[i][j] + int3[i][j];

        System.out.println("Result 2d Arrays");
        for(int i=0; i<intArray.length; i++) {
            System.out.println(Arrays.toString(intArray[i]));
        }
    }

    public void string2DArray(){
        String[][] cityNames = {
                {"Solan", "Shimla", "Kullu"},
                {"Mumbai", "Bangalore", "Chennai"},
                {"London", "Berlin", "Seattle"}
        };

        System.out.println("Printing city names");
        for(int i=0; i<cityNames.length; i++)
            System.out.println(Arrays.toString(cityNames[i]));
    }

    public static void main(String[] args){
        ArraysBasics arraysBasics = new ArraysBasics();
        arraysBasics.int2DArray();

        arraysBasics.string2DArray();

    }
}


