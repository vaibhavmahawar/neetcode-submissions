class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        mp = {}
        l = 0

        for r in range(len(nums)):
            if (r - l) > k:
                mp.pop(nums[l])
                l += 1
            if nums[r] in mp:
                return True
            mp[nums[r]] = r
        return False