class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            int value = Math.abs(nums[i]);

            if (1 <= value && value <= n) {
                if (nums[value - 1] > 0) {
                    nums[value - 1] *= -1;
                } else if (nums[value - 1] == 0) {
                    nums[value - 1] = -(n + 1);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] >= 0) {
                return i;
            }
        }

        return n + 1;
    }
}
