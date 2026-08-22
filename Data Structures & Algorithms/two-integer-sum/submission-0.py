class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        tm = {}

        for i, n in enumerate(nums):
            diff = target - n
            if diff in tm:
                return [tm[diff], i]
            tm[n] = i