class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] tp = new int[n];

        for (int i = 0; i < n; i++) {
            tp[(i + k) % n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = tp[i];
        }
    }
}