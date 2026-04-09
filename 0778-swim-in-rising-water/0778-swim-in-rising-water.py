import heapq


class Solution:
    def __init__(self):
        self.ROW = [+1, -1, 0, 0]
        self.COL = [0, 0, +1, -1]

    def isValidCell(self, n: int, row: int, column: int) -> bool:
        if row < 0 or column < 0 or row >= n or column >= n:
            return False
        return True

    def swimInWater(self, grid: List[List[int]]) -> int:
        heap = []
        heapq.heapify(heap)

        n = len(grid)
        visited = [[False for _ in range(n)] for _ in range(n)]

        heapq.heappush(heap, (grid[0][0], 0, 0))
        visited[0][0] = True

        while heap:
            cost, row, column = heapq.heappop(heap)
            if row == n - 1 and column == n - 1:
                return cost

            for i in range(4):
                next_row = row + self.ROW[i]
                next_column = column + self.COL[i]

                if not self.isValidCell(n, next_row, next_column):
                    continue

                if visited[next_row][next_column]:
                    continue

                next_time = max(cost, grid[next_row][next_column])
                heapq.heappush(heap, (next_time, next_row, next_column))
                visited[next_row][next_column] = True

        return -1
