class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        l, r = 0, 1
        maxProfit = 0

        while r < len(prices):
            if prices[l] < prices[r]:
                maxProfit += (prices[r] - prices[l])
            
            l += 1
            r += 1
        return maxProfit