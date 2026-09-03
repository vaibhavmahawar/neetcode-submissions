class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        l= 0
        maxProfit = 0

        for r in range(1,len(prices)):
            if prices[l] < prices[r]:
                maxProfit += (prices[r] - prices[l])
            
            l += 1
            r += 1
        return maxProfit