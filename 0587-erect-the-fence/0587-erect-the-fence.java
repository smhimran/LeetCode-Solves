class Solution {
    public int[][] outerTrees(int[][] trees) {
        Set<int[]> hull = new HashSet<>();
        int startIndex = 0;

        for (int i = 0; i < trees.length; i++) {
            if (trees[i][1] < trees[startIndex][1]) {
                startIndex = i;
            }
        }

        int previousIndex = startIndex;

        do {
            int selectedIndex = (previousIndex + 1) % trees.length;

            for (int i = 0; i < trees.length; i++) {
                int orientation = orientationOfPoints(trees[previousIndex], trees[i], trees[selectedIndex]);

                if (orientation < 0) {
                    selectedIndex = i;
                }
            }

            for (int i = 0; i < trees.length; i++) {
                if (i != previousIndex && i != selectedIndex && orientationOfPoints(trees[previousIndex], trees[i], trees[selectedIndex]) == 0 && inBetween(trees[previousIndex], trees[i], trees[selectedIndex])) {
                    hull.add(trees[i]);
                }
            }

            hull.add(trees[selectedIndex]);
            previousIndex = selectedIndex;
        } while (previousIndex != startIndex);

        return hull.toArray(new int[hull.size()][]);
    } 

    // returns -1 if counterclockwise, 1 if clockwise, 0 if colinear
    public int orientationOfPoints(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }

    // returns if point i is in between points p and q
    public boolean inBetween(int[] p, int[] i, int[] q) {
        boolean a = i[0] >= p[0] && i[0] <= q[0] || i[0] <= p[0] && i[0] >= q[0];
        boolean b = i[1] >= p[1] && i[1] <= q[1] || i[1] <= p[1] && i[1] >= q[1];
        return a && b;
    }
}
