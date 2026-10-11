class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int res = 0;
        for (int w : weights) {
            res = Math.max(res, w);
        }
        while (true) {
            int ships = 1;
            int m = res;
            for (int w : weights) {
                if (m - w < 0) {
                    ships++;
                    m = res;
                }
                m -= w;
            }
            if (ships <= days) {
                return res;
            }
            res++;
        }
    }
}