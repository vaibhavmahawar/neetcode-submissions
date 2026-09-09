public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int count = 0;

        for (int i = 0; count < n; i++) {
            int cur = i;
            int prev = nums[i];
            do {
                int nextIdx = (cur + k) % n;
                int tp = nums[nextIdx];
                nums[nextIdx] = prev;
                prev = tp;
                cur = nextIdx;
                count++;
            } while (i != cur);
        }
    }
}