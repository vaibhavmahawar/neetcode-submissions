class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        l, r = max(weights), sum(weights)
        res = r
        def canShip(m):
            ships, curr_mid = 1, m
            for w in weights:
                if curr_mid - w < 0:
                    ships += 1
                    if ships > days:
                        return False
                    curr_mid = m
                curr_mid -= w
            return True
        while l <= r:
            m = (l + r) // 2
            if canShip(m):
                res = min(res, m)
                r = m - 1
            else:
                l = m + 1
        return res