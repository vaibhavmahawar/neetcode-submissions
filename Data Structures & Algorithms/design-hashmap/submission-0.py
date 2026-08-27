class ListNode:
    def __init__(self, key=0, value=0):
        self.key = key
        self.value = value
        self.next = None
class MyHashMap:

    def __init__(self):
        self.map = [ListNode() for i in range(10**4)]

    def put(self, key: int, value: int) -> None:
        idx = key % len(self.map)
        cur = self.map[idx]
        while cur.next!= None:
            if cur.next.key == key:
                cur.next.value = value
                return
            cur = cur.next
        cur.next = ListNode(key, value)

    def get(self, key: int) -> int:
        cur = self.map[key % len(self.map)]
        while cur.next:
            if cur.next.key == key:
                return cur.next.value
            cur = cur.next
        return - 1

    def remove(self, key: int) -> None:
        cur = self.map[key % len(self.map)]
        while cur.next:
            if cur.next.key == key:
                cur.next = cur.next.next
                return
            cur = cur.next        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)