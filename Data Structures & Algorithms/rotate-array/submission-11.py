class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k %= n

        self.reverse(0, n - 1, nums)
        self.reverse(0, k - 1, nums)
        self.reverse(k, n - 1, nums)

    def reverse(self, l, r, nums) -> None:
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l, r = l + 1, r - 1