func diagonalSum(mat [][]int) int {
	var sum int

	n := len(mat)

	for i, j := 0, 0; i < n && j < n; i, j = i+1, j+1 {
		sum += mat[i][j]
	}

	for i, j := 0, n-1; i < n && j >= 0; i, j = i+1, j-1 {
		sum += mat[i][j]
	}

	if n%2 == 1 {
		sum -= mat[n/2][n/2]
	}

	return sum
}