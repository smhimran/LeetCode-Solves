class Solution {
    List<Integer> parent;

    private int find(int n) {
        if (parent.get(n) == n) {
            return n;
        }
        return find(parent.get(n));
    }

    private void join(int a, int b) {
        parent.set(find(b), find(a));
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;

        parent = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            parent.add(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    join(i, j);
                }
            }
        }

        int numberOfStonesRemoved = 0;

        for (int i = 0; i < n; i ++) {
            if (find(i) != i) {
                numberOfStonesRemoved++;
            }
        }

        return numberOfStonesRemoved;
    }
}