class FreqStack {
    private Map<Integer, Integer> count;
    private Map<Integer, Stack<Integer>> stacks;
    private int maxCount;

    public FreqStack() {
        count = new HashMap<>();
        stacks = new HashMap<>();
        maxCount = 0;
    }

    public void push(int val) {
        int valCount = count.getOrDefault(val, 0) + 1;
        count.put(val, valCount);
        if (valCount > maxCount) {
            maxCount = valCount;
            stacks.putIfAbsent(valCount, new Stack<>());
        }
        stacks.get(valCount).push(val);
    }

    public int pop() {
        int res = stacks.get(maxCount).pop();
        count.put(res, count.get(res) - 1);
        if (stacks.get(maxCount).isEmpty()) {
            maxCount--;
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */