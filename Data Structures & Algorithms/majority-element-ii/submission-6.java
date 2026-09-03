class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);

            if (count.size() <= 2) {
                continue;
            }

            HashMap<Integer, Integer> newCount = new HashMap<>();

            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                int num = entry.getKey();
                int c = entry.getValue();

                if (c > 1) {
                    newCount.put(num, c - 1);
                }
            }
            count = newCount;
        }

        List<Integer> res = new ArrayList<>();

        for (int n : count.keySet()) {
            int frequency = 0;

            for (int num : nums) {
                if (num == n) {
                    frequency++;
                }
            }

            if (frequency > nums.length / 3) {
                res.add(n);
            }
        }
        return res;
    }
}