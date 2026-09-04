class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            if nums[i] <= 0 or nums[i] > len(nums):
                nums[i] = len(nums) + 1

        for i in range(len(nums)):
            value = abs(nums[i])

            if value > len(nums):
                continue

            value -= 1

            if nums[value] > 0:
                nums[value] = -nums[value]

        for i in range(len(nums)):
            if nums[i] > 0:
                return i + 1

        return len(nums) + 1
