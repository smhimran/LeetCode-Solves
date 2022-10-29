class MinStack {
    Stack<Integer> mainStack;
    Stack<Integer> min;

    public MinStack() {
        mainStack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int value) {
        mainStack.push(value);
        if (min.empty() || value <= min.peek()) {
            min.push(value);
        }
    }
    
    public void pop() {
        int removed = mainStack.pop();
        if (removed == min.peek()) {
            min.pop();
        }
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */