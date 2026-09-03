class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int maxProfit = 0;

        for (int r = 1; r < prices.length; r++) {
            if (prices[l] < prices[r]) {
                maxProfit += prices[r] - prices[l];
            }

            l++;
        }
        return maxProfit;
    }
}