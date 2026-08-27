class ListNode{
    int key;
    int value;
    ListNode next;
    
    public ListNode(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class MyHashMap {
    private ListNode[] map;

    public MyHashMap() {
        map = new ListNode[10000];

        for(int i = 0; i < 10000; i++){
            map[i] = new ListNode(0,0);
        }
    }
    
    public void put(int key, int value) {
        int idx = key % map.length;
        ListNode cur = map[idx];
        while (cur.next != null){
            if(cur.next.key == key){
                cur.next.value = value;
                return;
            }
            cur = cur.next;
        }
        cur.next = new ListNode(key,value);
    }
    
    public int get(int key) {
        int idx = key % map.length;
        ListNode cur = map[idx];
        while(cur.next != null){
            if(cur.next.key == key){
                return cur.next.value;
            }
            cur = cur.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx = key % map.length;
        ListNode cur = map[idx];
        while(cur.next != null){
            if(cur.next.key == key){
                cur.next= cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */