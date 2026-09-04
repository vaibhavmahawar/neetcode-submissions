class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        # T=O(n) S=O(n)
        self.reverse(s, 0, len(s) - 1)

    def reverse(self, s, l, r):
        if l < r:
            s[l], s[r] = s[r], s[l]
            self.reverse(s, l + 1, r - 1)