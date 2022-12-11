/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair now = queue.poll();

            if (!queue.isEmpty() && queue.peek().getLevel() == now.getLevel()) {
                now.setNext(queue.peek().getNode());
            }

            if (now.getLeft() != null) {
                queue.add(new Pair(now.getLeft(), now.getLevel() + 1));
            }

            if (now.getRight() != null) {
                queue.add(new Pair(now.getRight(), now.getLevel() + 1));
            }
        }

        return root;
    }
}

class Pair {
    private Node node;
    private int level;

    public Pair() {

    }

    public Pair(Node node, int level) {
        this.node = node;
        this.level = level;
    }

    public Node getNode() {
        return node;
    }

    public int getLevel() {
        return level;
    }

    public void setNext(Node next) {
        node.next = next;
    }

    public Node getLeft() {
        return node != null ? node.left : null;
    }

    public Node getRight() {
        return node != null ? node.right : null;
    }
}