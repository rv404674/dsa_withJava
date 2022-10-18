package greedy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Problem LInk - https://www.codingninjas.com/codestudio/problems/1062658?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
// marked as easy, but it is a medium problem
// soln - https://www.youtube.com/watch?v=II6ziNnub1Q&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=46

// NOTE: Requirements.
// N <= 10^5
// NOTE: for same end time, use smaller index.

// NOTE: Approach. Greedy problem
// sort based on end time and try to fit it in one slot.
// TC - O(n) + O(nlogn) + O(n) ~= O(NlogN)
// SC - O(N)
class Meeting {
    int startTime;
    int endTime;
    int index;

    public Meeting(int startTime, int endTime, int index){
        this.startTime = startTime;
        this.endTime = endTime;
        this.index = index;
    }
}

class MeetingComparator implements Comparator<Meeting>{

    @Override
    public int compare(Meeting o1, Meeting o2) {
        if(o1.endTime < o2.endTime){
            return -1;
        } else if(o1.endTime > o2.endTime) {
            return 1;
        } else if(o1.index < o2.index){
            // endTime is same, so prefer smaller index
            return -1;
        }

        return 1;
    }
}

public class MaxMeetings {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {
        List<Meeting> meetingList = new ArrayList<>();
        for(int i=0; i<start.length; i++)
            meetingList.add(new Meeting(start[i], end[i], i+1));

        Comparator comparator = new MeetingComparator();
        Collections.sort(meetingList, comparator);

        List<Integer> result = new ArrayList<>();
        result.add(meetingList.get(0).index);
        int limit = meetingList.get(0).endTime;

        for(int i=1; i<start.length; i++){
            if(meetingList.get(i).startTime > limit){
                limit = meetingList.get(i).endTime;
                result.add(meetingList.get(i).index);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaxMeetings maxMeetings = new MaxMeetings();
        int[] start = {4,1,5,7,9,6,7,2,1,8} ;
        int[] end = {14,11,18,10,19,19,14,18,7,16};
        System.out.println(maximumMeetings(start, end));
    }
}
