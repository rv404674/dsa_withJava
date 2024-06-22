package greedy;

import java.util.*;

enum TRAINTYPE{
    ARRIVAL,
    DEPARTURE;
}


class Train {
    int time;
    TRAINTYPE traintype;

    public Train(int time, TRAINTYPE traintype){
        this.time = time;
        this.traintype = traintype;
    }
}

class TrainComparator implements Comparator<Train>{

    @Override
    public int compare(Train o1, Train o2) {
        // for -1, o1 shoudl stay as it is smaller
        return (o1.time - o2.time);
    }
}

/**
 * NOTE: Problem Link
 * https://www.codingninjas.com/codestudio/problems/799400?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
 *
 * NOTE: Approach1: Your Fav
 * Merge both arrays in a single one and sort (keep track for arrival and departure for both of them).
 * traverse from the starting, add +1 for arrival and -1 for departure.
 * TC - O(N) + O(N) + 2*O(nlogn) + 2*O(N) ~=  4*O(N) + 2*O(NlogN)
 * SC - O(2*N)
 *
 * NOTE: Approach2:
 * Striver - https://www.youtube.com/watch?v=dxVcMDI7vyI&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=47
 * Dry run through striver's example.
 * TC - 2*(Onlogn) + 2*O(N)
 * SC - O(1)
 */

public class MinPlatformsRequired {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        Arrays.sort(at);
        Arrays.sort(dt);

        int result = 1;
        int cnt = 1;
        int i=1, j=0;

        while(i<n && j<n){
            if(at[i]<=dt[j]){
                cnt+=1;
                i+=1;
            } else {
                cnt -=1;
                j+=1;
            }

            result = Math.max(result, cnt);
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] at = {900,940,950,1100,1500,1800};
        int[] dt = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(MinPlatformsRequired.calculateMinPatforms(at, dt,n));

    }
}
