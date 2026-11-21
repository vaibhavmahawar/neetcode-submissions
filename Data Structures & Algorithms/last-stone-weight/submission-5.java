class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int s : stones) {
            maxHeap.offer(-s);
        }
        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if (second > first) {
                maxHeap.offer(first - second);
            }
        }
        maxHeap.offer(0);
        return Math.abs(maxHeap.peek());
    }
}