class Solution {
    private boolean canShip(int[] weights, int days, int m) {
        int ships = 1, currMid = m;
        for (int w : weights) {
            if (currMid - w < 0) {
                ships++;
                if (ships > days) {
                    return false;
                }
                currMid = m;
            }
            currMid -= w;
        }
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;
        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }
        int res = r;

        while (l <= r) {
            int m = (l + r) / 2;
            if (canShip(weights, days, m)) {
                res = Math.min(res, m);
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
}