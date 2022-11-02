class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start, 0));
        visited.add(start);

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            System.out.println(now.getValue());
            String gene = now.getValue();

            if (gene.equals(end)) {
                return now.getLevel();
            }


            for (char c : new char[] {'A', 'C', 'G', 'T'}) {
                for (int i = 0; i < gene.length(); i++) {
                    String next = gene.substring(0, i) + c + gene.substring(i + 1);

                    if (!visited.contains(next) && bankSet.contains(next)) {
                        visited.add(next);
                        queue.add(new Node(next, now.getLevel() + 1));
                    }
                }
            }
        }

        return -1;
    }
}

class Node {
    private String value;
    private int level;

    public Node() {

    }

    public Node(String value, int level) {
        this.value = value;
        this.level = level;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}