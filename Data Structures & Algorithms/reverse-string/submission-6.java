class Solution {
    public void reverseString(char[] s) {
        // T = O(n), S = O(n)
        reverse(s, 0, s.length - 1);
    }

    private void reverse(char[] s, int l, int r) {
        if (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            reverse(s, l + 1, r - 1);
        }
    }
}