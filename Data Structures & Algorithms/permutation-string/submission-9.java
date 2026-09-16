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

        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if (count1[i] == count2[i]) {
                matches++;
            }
        }

        if (matches == 26) {
            return true;
        }

        for (int i = windowSize; i < s2.length(); i++) {
            int add = s2.charAt(i) - 'a';
            count2[add]++;

            if (count2[add] == count1[add]) {
                matches++;
            } else if (count2[add] == count1[add] + 1) {
                matches--;
            }

            int remove = s2.charAt(i - windowSize) - 'a';
            count2[remove]--;

            if (count2[remove] == count1[remove]) {
                matches++;
            } else if (count2[remove] == count1[remove] - 1) {
                matches--;
            }

            if (matches == 26) {
                return true;
            }
        }
        return false;
    }
}