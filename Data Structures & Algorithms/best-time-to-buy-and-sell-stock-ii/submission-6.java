class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1;
        int maxProfit = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                maxProfit += prices[r] - prices[l];
            }

            l++;
            r++;
        }
        return maxProfit;
    }
}
