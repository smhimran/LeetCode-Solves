class Solution {
private:
    vector<vector<char>> grid;
    bool visited[301][301];

    void dfs(int i, int j) {
        if (i >= grid.size() or j >= grid[i].size())
            return;

        if (visited[i][j]) 
            return;
        
        if (grid[i][j] == '0')
            return;

        visited[i][j] = true;

        dfs(i + 1, j);
        dfs(i, j + 1);
        dfs(i - 1, j);
        dfs(i, j - 1);
    }

public:
    int numIslands(vector<vector<char>>& grid) {
        this->grid = grid;

        int numberOfIslands = 0;

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[i].size(); j++) {
                if (grid[i][j] == '1' and !visited[i][j]) {
                    numberOfIslands++;
                    dfs(i, j);
                }
            }
        }

        return numberOfIslands;
    }
};