package binarySearch;

public class ShipmentInDdays {
    // https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
    // Medium

    // Requirements:
    // 1 <= days <= weights.length <= 5 * 104
    // 1 <= weights[i] <= 500
    // need to find the min cost in which shipment can be shipped in days.
    // min = max of (all weights)
    // max = sum of (all)
    // THINK the above.
    // Perform BS on above.
    // TC: O(nlogn)
    public int shipWithinDays(int[] weights, int days) {
        int lo = -1;
        for(int x: weights)
            lo = Math.max(lo, x);

        int hi = 0;
        for(int x:weights)
            hi = hi +x;

        // NOTE: dont just do <= everywhere.
        // think about it first.
        int result = 0;

        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if (canShip(weights, mid, days)) {
                // if can ship with this capacity in D days.
                // be a bit optimistic
                result = mid;
                hi = mid - 1;
            } else {
                // if can't ship with this capacity
                // ignore this number and move ahead.
                lo = mid + 1;
            }
        }

        return result;
    }

    public boolean canShip(int[] weights, int cap, int days){
        // canShip
        int curDays = 1;
        int tempSum = 0;
        for(int weight: weights){
            tempSum += weight;

            if(tempSum > cap) {
                curDays += 1;
                tempSum = weight;
            }
        }

        return curDays <= days;

    }
}
