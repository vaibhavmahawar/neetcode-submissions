class FreqStack:

    def __init__(self):
        self.count = defaultdict(int)
        self.stack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        self.count[val] += 1

    def pop(self) -> int:
        max_count = max(self.count.values())
        i = len(self.stack) - 1
        while self.count[self.stack[i]] != max_count:
            i -= 1
        self.count[self.stack[i]] -= 1
        return self.stack.pop(i)


# Your FreqStack object will be instantiated and called as such:
# obj = FreqStack()
# obj.push(val)
# param_2 = obj.pop()