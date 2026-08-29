class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] freq = new ArrayList[nums.length + 1];

        for(int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()){
            int n = entry.getKey();
            int c = entry.getValue();

            freq[c].add(n);
        }

        int[] res = new int[k];
        int idx = 0;

        for (int i = freq.length - 1; i > 0; i--){
            for (int j = 0; j < freq[i].size(); j++){
                int n = freq[i].get(j);
                res[idx++] = n;

                if (idx == k){
                    return res;
                }
            }
        }
        return res;
    }
}