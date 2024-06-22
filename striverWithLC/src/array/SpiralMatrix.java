package array;

import java.util.ArrayList;
import java.util.List;

// AC in 25mins
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int rows = matrix.length;
        int col = matrix[0].length;

        int left = 0, right = col -1;
        int top = 0, bottom = rows - 1;

        int totalCells = rows * col;
        while(true){
            // traverse the top row
            for(int i=left; i<=right; i++)
                ans.add(matrix[top][i]);
            top +=1;

            if(isMatrixFullyTraversed(totalCells, ans))
                break;

            // traverse the rightmost row
            for(int i = top; i<=bottom; i++)
                ans.add(matrix[i][right]);
            right -=1;

            if(isMatrixFullyTraversed(totalCells, ans))
                break;



            // traverse the bootom row
            for (int i = right; i >= left; i--)
                ans.add(matrix[bottom][i]);
            bottom -= 1;

            if(isMatrixFullyTraversed(totalCells, ans))
                break;
            // traverse the bootom row
            // Edge case
            // [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
            // FIXME: easy way, if size of arraylist becomes size of matrix, return.
//            if (top <= bottom) {
//                for (int i = right; i >= left; i--)
//                    ans.add(matrix[bottom][i]);
//                bottom -= 1;
//            }



            // traverse the lefmost row
            for(int i=bottom; i>=top; i--)
                ans.add(matrix[i][left]);
            left +=1;

            if(isMatrixFullyTraversed(totalCells, ans))
                break;
        }

        return ans;

    }

    public static boolean isMatrixFullyTraversed(int totalCells, List<Integer> arrayList){
        return totalCells == arrayList.size();
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
}
