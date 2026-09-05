class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                String skipL = s.substring(l + 1, r + 1);
                String skipR = s.substring(l, r);

                return skipL.equals(new StringBuilder(skipL).reverse().toString())
                    || skipR.equals(new StringBuilder(skipR).reverse().toString());
            }
            l++;
            r--;
        }
        return true;
    }
}