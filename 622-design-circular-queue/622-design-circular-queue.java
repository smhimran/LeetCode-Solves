class MyCircularQueue {
    int limit;
    int numberOfElements;
    boolean empty;
    
    QueueElement front;
    QueueElement rear;
    
    public MyCircularQueue(int k) {
        this.limit = k;
        numberOfElements = 0;
        empty = true;
    }
    
    public boolean enQueue(int value) {
        if (numberOfElements < limit) {
            if (empty) {
                rear = new QueueElement(value);
                front = rear;
                empty = false;
            } else {
                QueueElement now = new QueueElement(value);
                rear.next = now;
                rear = now;
            }
            numberOfElements++;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean deQueue() {
        if (numberOfElements > 0) {
            front = front.next;
            numberOfElements--;
            
            if (numberOfElements == 0) {
                empty = true;
            }
            
            return true;
        } else {
            return false;
        }
    }
    
    public int Front() {
        if (empty) {
            return -1;
        } else {
            return front.value;
        }
    }
    
    public int Rear() {
        if (empty) {
            return -1;
        } else {
            return rear.value;
        }
    }
    
    public boolean isEmpty() {
        return empty;
    }
    
    public boolean isFull() {
        return (numberOfElements == limit);
    }
}

class QueueElement {
    int value;
    QueueElement next;
    
    public QueueElement(int value) {
        this.value = value;
        next = null;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */