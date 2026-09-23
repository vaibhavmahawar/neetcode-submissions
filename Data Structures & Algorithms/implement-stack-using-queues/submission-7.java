class MyStack {
    private Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.offer(x);
    }
    
    public int pop() {
        for (int i = 0; i < q.size() - 1; i++) {
            q.offer(q.poll());
        }
        return q.poll();
    }
    
    public int top() {
        int last = 0;
        for (int i = 0; i < q.size(); i++) {
            last = q.poll();
            q.offer(last);
        }
        return last;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */