class Solution {
    public int numSquares(int n) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        queue.add(new Node(n, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            visited.add(now);

            if (now.getValue() == 0) {
                return now.getLevel();
            }

            int sqrt = (int) Math.sqrt(now.getValue());

            for (int i = sqrt; i > 0; i--) {
                int remaining = now.getValue() - (i * i);
                if (remaining == 0) {
                    return now.getLevel() + 1;
                }

                Node next = new Node(remaining, now.getLevel() + 1);
                if (!visited.contains(next)) {
                    queue.add(next);
                }
            }
        }

        return n;
    }

    private class Node {
        private int value;
        private int level;

        public Node(int value, int level) {
            this.value = value;
            this.level = level;
        }

        public int getValue() {
            return value;
        }

        public int getLevel() {
            return level;
        }
    }
}