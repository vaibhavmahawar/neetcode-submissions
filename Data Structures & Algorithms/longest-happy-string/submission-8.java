class Solution {
    public String longestDiverseString(int a, int b, int c) {
        return String.join("", rec(a, b, c, 'a', 'b', 'c'));
    }
    private List<String> rec(int max1, int max2, int max3, char char1, char char2, char char3) {
        if (max1 < max2) {
            return rec(max2, max1, max3, char2, char1, char3);
        }
        if (max2 < max3) {
            return rec(max1, max3, max2, char1, char3, char2);
        }
        if (max2 == 0) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < Math.min(2, max1); i++) {
                result.add(String.valueOf(char1));
            }
            return result;
        }
        int use1 = Math.min(2, max1);
        int use2 = (max1 - use1 >= max2) ? 1 : 0;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < use1; i++) {
            res.add(String.valueOf(char1));
        }
        for (int i = 0; i < use2; i++) {
            res.add(String.valueOf(char2));
        }
        res.addAll(rec(max1 - use1, max2 - use2, max3, char1, char2, char3));
        return res;
    }
}