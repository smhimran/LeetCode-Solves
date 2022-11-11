class LRUCache {
    Map<Integer, Integer> store;

    public LRUCache(int capacity) {
        store = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry entry) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        return store.getOrDefault(key, -1);
    }    
    
    public void put(int key, int value) {
        store.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */