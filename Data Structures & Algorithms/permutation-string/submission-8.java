class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        int windowSize = s1.length();

        for (int i = 0; i < windowSize; i++) {
            count2[s2.charAt(i) - 'a']++;
        }

        boolean same = true;

        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                same = false;
                break;
            }
        }

        if (same) {
            return true;
        }

        for (int i = windowSize; i < s2.length(); i++) {
            count2[s2.charAt(i) - 'a']++;
            count2[s2.charAt(i - windowSize) - 'a']--;

            same = true;

            for (int j = 0; j < 26; j++) {
                if (count1[j] != count2[j]) {
                    same = false;
                    break;
                }
            }

            if (same) {
                return true;
            }
        }

        return false;
    }
}
