class FreqStack {
    private Map<Integer, Integer> count;
    private List<Integer> stack;

    public FreqStack() {
        count = new HashMap<>();
        stack = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        count.put(val, count.getOrDefault(val, 0) + 1);
    }
    
    public int pop() {
        int maxCount = Collections.max(count.values());
        int i = stack.size() -  1;
        while (count.get(stack.get(i)) != maxCount) {
            i--;
        }
        int val = stack.remove(i);
        count.put(val, count.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */