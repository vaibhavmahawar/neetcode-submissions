class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        lastSeen = [0] * 128
        left = 0
        res = 0

        for right in range(len(s)):
            c = s[right]
            left = max(left, lastSeen[ord(c)])
            res = max(res, right - left + 1)
            lastSeen[ord(c)] = right + 1

        return res