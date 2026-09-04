class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        n = len(nums)

        for i in range(n):
            if nums[i] <= 0 or nums[i] > n:
                nums[i] = n + 1

        for i in range(n):
            id = abs(nums[i])

            if id > n:
                continue
            id -= 1

            if nums[id] > 0:
                nums[id] = -nums[id]

        for i in range(n):
            if nums[i] > 0:
                return i + 1
        return n + 1