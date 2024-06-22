package binarySearch;

public class kokoEatingBananas {
    // [3,6,7,11], h=8
    // Binary search -> It's difficult to identify that binaryseach can be applied

    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int answer = 0;
        int hi = -1;

        for(int pile: piles)
            hi = Math.max(pile, hi);

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(canFinish(piles, mid, h)){
                answer = mid;
                // try more less speed
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }

        return answer;

    }

    public boolean canFinish(int[] piles, int speed, int h){
        int totalTime = 0;
        // [3,6,7,11], h =3, h=4
        for(int pile: piles){
            totalTime += pile/speed;
            if(pile%speed !=0){
                totalTime +=1;
            }
        }

        return totalTime <= h;
    }

    public static void main(String[] args) {
        kokoEatingBananas x = new kokoEatingBananas();
        int[] input = {3,6,7,11};
        x.minEatingSpeed(input,8);
    }
}
