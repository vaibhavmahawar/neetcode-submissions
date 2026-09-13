class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> window = new HashMap<>();
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            if (r - l > k) {
                window.remove(nums[l]);
                l++;
            }
            if (window.containsKey(nums[r])) {
                return true;
            }
            window.put(nums[r], r);
        }
        return false;
    }
}