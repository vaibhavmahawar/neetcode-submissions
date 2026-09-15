class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int l = 0;
        int[] count = new int[26];

        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'A']++;

            while ((r - l + 1) - getMax(count) > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    private int getMax(int[] count) {
        int max = 0;

        for (int num : count) {
            max = Math.max(max, num);
        }

        return max;
    }
}