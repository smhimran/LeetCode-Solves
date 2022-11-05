class Solution {
    Set<String> dictionary;
    Set<String> resultSet;

    char[][] board;
    boolean[][] visited;
    int n, m, maxLength;

    public Solution() {
        resultSet = new HashSet<>();
        dictionary = new HashSet<>();
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.n = board.length;
        this.m = board[0].length;


        for (String word: words) {
            dictionary.add(word);
            maxLength = Math.max(maxLength, word.length());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.visited = new boolean[this.n][this.m];
                dfs(i, j, "");
            }
        }
        
        return new ArrayList<>(resultSet);
    }

    private void dfs(int i, int j, String word) {
        if (word.length() >= maxLength) {
            return;
        }

        if (i < 0 || j < 0) {
            return;
        }
        
        if (i == n || j == m) {
            return;
        }

        if (visited[i][j]) {
            return;
        }

        String now = word + board[i][j];

        if (dictionary.contains(now)) {
            resultSet.add(now);
            dictionary.remove(now);
        }
        
        visited[i][j] = true;

        dfs(i - 1, j, now);
        dfs(i + 1, j, now);
        dfs(i, j - 1, now);
        dfs(i, j + 1, now);

        visited[i][j] = false;
    }
}