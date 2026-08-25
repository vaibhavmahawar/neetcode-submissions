class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        count = {}
        for n in nums:
            count[n] = 1 + count.get(n,0)
        
        for n in nums:
            if count[n] > len(nums) // 2:
                return n