/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    private Map<Integer, Integer> cache = new HashMap<>();
    private int get(int index, MountainArray mountainArr) {
        if (!cache.containsKey(index)) {
            cache.put(index, mountainArr.get(index));
        }
        return cache.get(index);
    }
    private int binarySearch(int l, int r, boolean ascending, MountainArray mountainArr, int target) {
        while (l <= r) {
            int m = (l + r) >> 1;
            int val = get(m, mountainArr);
            if (val == target) {
                return m;
            }
            if (ascending == (val < target)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int l = 1, r = length - 2, peak = 0;
        while (l <= r) {
            int m = (l + r) >> 1;
            int left = get(m - 1, mountainArr);
            int mid = get(m, mountainArr);
            int right = get(m + 1, mountainArr);
            if (left < mid && mid < right) {
                l = m + 1;
            } else if (left > mid && mid > right) {
                r = m - 1;
            } else {
                peak = m;
                break;
            }
        }
        int res = binarySearch(0, peak, true, mountainArr, target);
        if (res != -1) {
            return res;
        }
        return binarySearch(peak, length - 1, false, mountainArr, target);
    }
}