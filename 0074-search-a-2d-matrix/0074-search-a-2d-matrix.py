class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        top = 0
        bottom = len(matrix) - 1

        while top <= bottom:
            mid = (top + bottom) // 2
            
            if matrix[mid][0] <= target and matrix[mid][-1] >= target:
                return self.foundInRow(matrix[mid], target)

            elif matrix[mid][0] > target:
                bottom = mid - 1

            elif matrix[mid][-1] < target:
                top = mid + 1
        
        return False


    def foundInRow(self, row: List[int], target: int) -> bool:
        left = 0
        right = len(row) - 1

        while left <= right:
            mid = (left + right) // 2

            if row[mid] == target:
                return True

            elif row[mid] > target:
                right = mid - 1
            
            else:
                left = mid + 1

        return False