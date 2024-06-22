package array;

public class RotateImage {
    // Approach 1: Use 2d array
    // pattern
    // new row will become = n-i-1;
    // TC, SC - O(n^2), O(n^2)
    public void rotateBrute(int[][] matrix) {
        int[][] tmp = new int[matrix.length][matrix.length];
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[j][n - i - 1] = matrix[i][j];
            }
        }
    }

    // Video - https://www.youtube.com/watch?v=Y72QeX0Efxw
    // PS - https://leetcode.com/problems/rotate-image/
    // NOTE: Approach
    // Transpose
    // then reverse every row. you get the answer.
    public void rotate(int[][] matrix) {
        // get the transpose
        // NOTE: transpose is basically making a whole column to a row.
        // dry run for better understanding
        int i,j;
        int n = matrix.length;
        for(i =0;i<n;i++){
            for(j=i; j<n;j++){
                // swap a[i][j] with a[j][i]
                swap(matrix, i,j);
            }
        }

        // now reverse every row.
        for(i = 0; i<n; i++){
            for( j=0; j<n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }

    public void swap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}


