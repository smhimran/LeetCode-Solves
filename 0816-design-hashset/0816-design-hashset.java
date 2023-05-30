class MyHashSet {
    private boolean[] exists;

    public MyHashSet() {
        this.exists = new boolean[1000006];
    }
    
    public void add(int key) {
        exists[key] = true;
    }
    
    public void remove(int key) {
        exists[key] = false;
    }
    
    public boolean contains(int key) {
        return exists[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */