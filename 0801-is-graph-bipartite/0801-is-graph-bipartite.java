class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                if (!isBipartite(i, 1, color, graph)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isBipartite(int source, int currentColor, int[] color, int[][] graph) {
        for (int target: graph[source]) {
            if (color[target] == currentColor) {
                return false;
            }

            if (color[target] == 0) {
                int nextColor = currentColor == 1? 2 : 1;
                color[target] = nextColor;

                if (!isBipartite(target, nextColor, color, graph)) {
                    return false;
                }
            }
        }

        return true;
    }
}