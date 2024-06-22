package array;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class BestTimeToBuyStock1 {

    /**
     * Approach - rMax. and then loop the array.
     * 2*O(N), O(N)
     */
    public static int maxProfitAppr1(int[] prices) {
        if(prices.length < 2)
            return 0;

        int[] lMinArray = new int[prices.length];
        lMinArray[0] = prices[0];
        int result = 0;

        for (int i=1; i<prices.length; i++)
            lMinArray[i] = min(lMinArray[i-1], prices[i]);

        for (int i=0; i<prices.length; i++)
            result = max(result, prices[i] - lMinArray[i]);

        return result;
    }

    /**
     * Approach - rMax. and then loop the array.
     * O(N), O(1)
     */
    public static int maxProfit(int[] prices) {
        int mxProfit = 0;
        int lowestSellingPrice = Integer.MAX_VALUE;
        int profitIfSoldToday = 0;

        for (int i=0; i<prices.length; i++){
            if(prices[i] < lowestSellingPrice) {
                lowestSellingPrice = prices[i];
            }

            profitIfSoldToday = prices[i] - lowestSellingPrice;
            if(profitIfSoldToday > mxProfit)
                mxProfit = max(mxProfit, profitIfSoldToday);
        }

        return mxProfit;

    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
