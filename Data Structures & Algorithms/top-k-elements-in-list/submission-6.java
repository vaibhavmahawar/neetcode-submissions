class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            
            if (count.containsKey(n)){
                count.put(n, count.get(n) + 1);
            } else {
                count.put(n, 1);
            }
        }

        List<Integer>[] freq = new ArrayList[nums.length + 1];

        for(int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        Iterator<Integer> it = count.keySet().iterator();

        while (it.hasNext()){
            int n = it.next();
            int c = count.get(n);
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