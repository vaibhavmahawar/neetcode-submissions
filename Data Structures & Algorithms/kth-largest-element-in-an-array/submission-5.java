class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    private int quickSelect(int[] nums, int l, int r, int k) {
        int pivot = nums[r];
        int p = l;
        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                int tmp = nums[p];
                nums[p] = nums[i];
                nums[i] = tmp;
                p++;
            }
        }
        int tmp = nums[p];
        nums[p] = nums[r];
        nums[r] = tmp;
        if (p > k) {
            return quickSelect(nums, l, p - 1, k);
        } else if (p < k) {
            return quickSelect(nums, p + 1, r, k);
        } else {
            return nums[p];
        }
    }
}