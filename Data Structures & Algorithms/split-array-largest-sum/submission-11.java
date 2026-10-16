class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0, res = 0;
        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }
        res = r;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (canSplit(nums, k, m)) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
    private boolean canSplit(int[] nums, int k, int largest) {
        int subarray = 1, curSum = 0;
        for (int num : nums) {
            curSum += num;
            if (curSum > largest) {
                subarray++;
                if (subarray > k) return false;
                curSum = num;
            }
        }
        return true;
    }
}