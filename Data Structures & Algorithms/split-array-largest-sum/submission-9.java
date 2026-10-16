class Solution {
    private int[] prefix;
    private int n;
    public int splitArray(int[] nums, int k) {
        n = nums.length;
        prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int l = Integer.MIN_VALUE, r = 0;
        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }
        int res = r;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (canSplit(m, k)) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
    private boolean canSplit(int largest, int k) {
        int subarrays = 0, i = 0;
        while (i < n) {
            int l = i + 1, r = n;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (prefix[m] - prefix[i] <= largest) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            subarrays++;
            i = r;
            if (subarrays > k) {
                return false;
            }
        }
        return true;
    }
}