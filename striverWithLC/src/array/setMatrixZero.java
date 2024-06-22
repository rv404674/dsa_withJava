package array;

import java.util.HashSet;

public class setMatrixZero {

    /**
     * Requirements - 1<m,n<=200
     * NOTE: approach 1: Use hashset
     * traverse all grid, store 0 column and row num in a hashet.
     * then traverse again, check if column or row in isn hashset, then set 0
     * TC - 2*O(n2), SC - 2*O(n)
     *
     * NOTE: approach2:
     * set the whole row/column zero while traversing.
     * TC, SC - O(N*M) * O(N+M), O(n)
     */
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> columnSet = new HashSet<>();

        int row = matrix.length;
        int column = matrix[0].length;

        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                if(matrix[i][j] == 0) {
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }

        for(int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                if(rowSet.contains(i) || columnSet.contains(j))
                    matrix[i][j] = 0;
            }
        }

    }
}
