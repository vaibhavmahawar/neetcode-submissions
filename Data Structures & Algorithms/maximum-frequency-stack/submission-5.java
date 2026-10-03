class FreqStack {
    private Map<Integer, Integer> count;
    private List<Stack<Integer>> stacks;

    public FreqStack() {
        count = new HashMap<>();
        stacks = new ArrayList<>();
        stacks.add(new Stack<>());
    }

    public void push(int val) {
        int valCount = count.getOrDefault(val, 0) + 1;
        count.put(val, valCount);
        if (valCount == stacks.size()) {
            stacks.add(new Stack<>());
        }
        stacks.get(valCount).push(val);
    }

    public int pop() {
        Stack<Integer> topStack = stacks.get(stacks.size() - 1);
        int res = topStack.pop();
        count.put(res, count.get(res) - 1);
        if (topStack.isEmpty()) {
            stacks.remove(stacks.size() - 1);
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