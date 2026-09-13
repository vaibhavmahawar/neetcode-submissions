class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> map = new HashSet<>();
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            if (r - l > k) {
                map.remove(nums[l]);
                l++;
            }
            if (map.contains(nums[r])) {
                return true;
            }
            map.add(nums[r]);
        }
        return false;
    }
}