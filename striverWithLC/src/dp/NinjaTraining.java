package dp;

import java.util.Arrays;

// NOTE: Really good problem on DP.
// will clear your basics about 2d dp - https://www.youtube.com/watch?v=AE39gJYuRog&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=8
// top to bottom
// n-1 day to 0 zero.
// makes sense. on day3 pick a task and then move to day2 ..
public class NinjaTraining {
    public static int ninjaTraining(int n, int points[][]) {
        // on n-1, you need to try all tasks
        // nX4 matrix
        int[][] dp = new int[n][4];
        for(int i=0; i<n;i++)
            Arrays.fill(dp[i], -1);
        return recurse(n-1, 3, points, dp);
    }

    public static int recurse(int days, int last, int[][] points, int[][] dp){
        if(days == 0){
            // base case
            // dont pick the task done on previous day
            int maxi = -1;
            for(int task = 0; task<3; task++)
                if(task != last)
                    maxi = Math.max(maxi, points[0][task]);
            dp[days][last] = maxi;
            return maxi;
        }

        if(dp[days][last] != -1)
            return dp[days][last];


        int maxi = -1;
        for(int task=0; task<3; task++){
            if(task != last){
                // if you perform task i on day days (now), you cant perform i on day days-1
                int point = points[days][task] + recurse(days-1, task, points, dp);
                maxi = Math.max(maxi, point);
            }
        }

        dp[days][last] = maxi;
        return dp[days][last] ;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] points = {{10,40,70}, {20,50,80}, {30,60,90}};
        System.out.println(ninjaTraining(n, points));
    }

}
