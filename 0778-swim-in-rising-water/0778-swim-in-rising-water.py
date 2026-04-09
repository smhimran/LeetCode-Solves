class Solution:
    def __init__(self):
        self.ROW = [+1, -1, 0, 0]
        self.COL = [0, 0, +1, -1]

    def _dfs(self, row, col, t, grid, visited, visitable, n):
        stack = [(row, col)]
        while stack:
            r, c = stack.pop()
            if (r, c) in visited:
                continue

            visited[(r, c)] = True

            for i in range(4):
                nr = r + self.ROW[i]
                nc = c + self.COL[i]

                if nr < 0 or nr >= n or nc < 0 or nc >= n:
                    continue
                if (nr, nc) in visited:
                    continue

                if grid[nr][nc] <= t:
                    stack.append((nr, nc))
                else:
                    visitable[grid[nr][nc]].append((nr, nc))

    def swimInWater(self, grid: List[List[int]]) -> int:
        visited = {}
        visitable = defaultdict(list)

        visitable[grid[0][0]].append((0, 0))

        t = 0
        n = len(grid)

        while t <= 2500:
            for row, col in visitable[t]:
                if (row, col) in visited:
                    continue
                self._dfs(row, col, t, grid, visited, visitable, n)

            # Check AFTER all DFS expansions at time t are done
            if (n - 1, n - 1) in visited:
                return t

            t += 1

        return -1
