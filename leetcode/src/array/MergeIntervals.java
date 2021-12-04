package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// NOTE: Tutorial Link
// https://www.youtube.com/watch?v=2JzRBPFYbKE
// Time Complexity = O(nlogn) + O(n)
// Space = O(n)

public class MergeIntervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals.length <=1)
                return intervals;

            List<int[]> result = new ArrayList<>();
            Arrays.sort(intervals, (arr1,arr2) -> Integer.compare(arr1[0], arr2[0]));

            int start = intervals[0][0];
            int end = intervals[0][1];
            for(int[] i:intervals){
                if(i[0] <= end)
                    end = Math.max(end, i[1]);
                else{
                    result.add(new int[]{start, end});
                    start = i[0];
                    end = i[1];
                }
            }

            result.add(new int[]{start, end});
            // NOTE:
            // size() vs length
            // size() - will give you the total elements in a collection. Size is applicable on collections.
            // eg
            // int[] x = new int[5];
            // x[0] = 1;
            // here size=1, whereas lenght = 5
            // for list
            // [ [1,2], [3,4] ]
            // size = 2.
            // NOTE: creating a 2d array here.
            return result.toArray(new int[result.size()][]);
        }
    }
}
