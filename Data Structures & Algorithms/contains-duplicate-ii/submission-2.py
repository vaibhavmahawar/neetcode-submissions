class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        win = {}
        l = 0

        for r in range(len(nums)):
            if (r - l) > k:
                win.pop(nums[l])
                l += 1
            if nums[r] in win:
                return True
            win[nums[r]] = r
        return False