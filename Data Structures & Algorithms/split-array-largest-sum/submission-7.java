public class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int[] nextDp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        for (int m = 1; m <= k; m++) {
            Arrays.fill(nextDp, Integer.MAX_VALUE);
            for (int i = n - 1; i >= 0; i--) {
                int curSum = 0;
                for (int j = i; j < n - m + 1; j++) {
                    curSum += nums[j];
                    nextDp[i] = Math.min(nextDp[i], Math.max(curSum, dp[j + 1]));
                }
            }
            int[] temp = dp;
            dp = nextDp;
            nextDp = temp;
        }
        return dp[0];
    }
}