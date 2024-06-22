package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingRoomTwo {

    /**
     * NOTE: Approach1:
     * Merge all in a single array with S and E (s denotes s, E denotes end).
     * Eg. [[0,30],[5,10],[15,20]]
     * [0,5,10,15,20,30]
     * [s,s,e,s,e,e]
     *
     * then for s do +1 and for end -1. store the max. and you have your anser.
     * TC - O(nlogn) + O(n), Space - 3* O(n)
     *
     * NOTE: Approach 2
     * NOTE: Accepted. Solved within 20mins.
     * sort(both the start time) and endtime array.
     * and then process.
     *
     * TC - O(n) + 2*O(nlogn) + O(n)
     * SC - 2*O(n)
     */
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            List<Integer> startList = new ArrayList<>();
            List<Integer> endList = new ArrayList<>();

            for(int i = 0; i< intervals.length; i++){
                int[] tmp = intervals[i];
                startList.add(tmp[0]);
                endList.add(tmp[1]);
            }

            Collections.sort(startList);
            Collections.sort(endList);

            int result = 0;
            int tmpRoom = 0;
            int i=0;
            int j=0;

            while(i<intervals.length && j<intervals.length){
                if(startList.get(i) < endList.get(j)){
                    tmpRoom +=1;
                    i+=1;
                } else {
                    tmpRoom -=1;
                    j+=1;
                }

                result = Math.max(result, tmpRoom);
            }

            return result >0? result : 1;
        }
    }
}
