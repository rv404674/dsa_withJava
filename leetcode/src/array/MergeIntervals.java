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

        /**
         * Time - O(nlogn) + O(n*k)
         * space - O(n)
         * Wrote Myself - Compared one by one.
         */
        public int[][] mergeAppr1(int[][] intervals) {
            // use your own approach
            if(intervals.length <= 1)
                return intervals;

            Arrays.sort(intervals, (o1,o2) -> o1[0]-o2[0]);

            List<int[]> result = new ArrayList<>();
            result.add(new int[]{intervals[0][0], intervals[0][1]});

            for (int i = 1; i< intervals.length; i++){
                int[] prevInterval = result.get(result.size() - 1);
                int[] curInterval = intervals[i];

                if (prevInterval[1] >= curInterval[0]){
                    result.set(result.size() - 1, new int[]{prevInterval[0], Math.max(curInterval[1], prevInterval[1])});
                } else {
                    result.add(new int[]{curInterval[0], curInterval[1]});
                }
            }

            return result.toArray(new int[result.size()][]);
        }

        /**
         * The diff b/w above one and this approach is that, here we are checking one by one.
         * Just process until you find an invalid case.
         *
         * also because of this approach, we dont need to update the original array.
         */
        public int[][] merge(int[][] intervals) {
            if (intervals.length <=1)
                return intervals;

            Arrays.sort(intervals, (((o1, o2) -> o1[0] - o2[0])));
            List<int[]> results = new ArrayList<>();

            int start = intervals[0][0];
            int end = intervals[0][1];

            for (int[] i: intervals) {
                if(end >= i[0]) {
                    end = Math.max(end, i[1]);
                } else {
                    // add to the result now.
                    results.add(new int[]{start, end});
                    start = i[0];
                    end = i[1];
                }
            }

            results.add(new int[]{start, end});
            return results.toArray(new int[results.size()][]);
        }

    }
}
