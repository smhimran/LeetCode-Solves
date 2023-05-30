class MyHashSet {
private:
    bool exists[1000006];
public:
    MyHashSet() {
        memset(exists, false, sizeof(exists) / sizeof(exists[0]));
    }
    
    void add(int key) {
        exists[key] = true;
    }
    
    void remove(int key) {
        exists[key] = false;
    }
    
    bool contains(int key) {
        return exists[key];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */