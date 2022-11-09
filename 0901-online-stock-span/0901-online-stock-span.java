class StockSpanner {
    Stack<Pair> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        if (stack.empty()) {
            stack.push(new Pair(price, 1));
            return 1;
        } else {
            int result = 1;

            while (!stack.empty() && stack.peek().price <= price) {
                result += stack.pop().span;
            }

            stack.push(new Pair(price, result));
            return result;
        }
    }
}

class Pair {
    int price;
    int span;

    public Pair(int price, int span) {
        this.price = price;
        this.span = span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */