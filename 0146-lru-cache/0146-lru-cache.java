class LRUCache {
    Map<Integer, Node> store;
    Node left;
    Node right;
    int capacity;
    int numberOfElements;

    public LRUCache(int capacity) {
        store = new HashMap<>();
        this.capacity = capacity;
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        left.next = right;
        right.prev = left;
        numberOfElements = 0;
    }
    
    public int get(int key) {
        if (store.containsKey(key)) {
            Node node = store.get(key);
            evict(node);
            addNode(node);
            return node.value;
        } else {
            return -1;
        }
    }    
    
    public void put(int key, int value) {
        if (store.containsKey(key)) {
            Node node = store.get(key);
            evict(node);
            node.value = value;
            addNode(node);
        } else {
            Node node = new Node(key, value);
            addNode(node);

            if (numberOfElements < capacity) {
                numberOfElements++;
            } else {
               evict();
            }
        }
    }

    private void evict() {
        store.remove(left.next.key);
        left.next = left.next.next;
        left.next.prev = left;
    }

    private void evict(Node node) {
        store.remove(node.key);
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addNode(Node node) {
        node.prev = right.prev;
        right.prev.next = node;
        node.next = right;
        right.prev = node;

        store.put(node.key, node);
    }
}

class Node {
    int key, value;
    Node prev, next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */