class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        set_nums = set()

        for num in nums:
            set_nums.add(num)

        i = 1
        while i in set_nums:
            i += 1

        return i