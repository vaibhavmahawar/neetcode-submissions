class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int l = 0;
        int[] count = new int[26];

        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'A']++;

            while ((r - l + 1) - java.util.Arrays.stream(count).max().getAsInt() > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}