class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Cell> queue = new LinkedList<>();

        Cell start = new Cell(entrance[0], entrance[1], 0);
        queue.add(start);

        Set<Pair> visited = new HashSet<>();

        visited.add(new Pair(entrance[0], entrance[1]));

        int[] ROW = {+1, -1, 0, 0};
        int[] COL = {0, 0, +1, -1};

        while (!queue.isEmpty()) {
            Cell currentCell = queue.poll();

            if (isEdge(currentCell, maze.length, maze[0].length)) {
                if (!currentCell.equals(start)) {
                    return currentCell.getLevel();
                }
            }

            for (int i = 0; i < 4; i++) {
                int newRow = currentCell.getRow() + ROW[i];
                int newColumn = currentCell.getColumn() + COL[i];

                if (isValid(newRow, newColumn, maze.length, maze[0].length) && maze[newRow][newColumn] == '.') {
                    if (!visited.contains(new Pair(newRow, newColumn))) {
                        queue.add(new Cell(newRow, newColumn, currentCell.getLevel() + 1));
                        visited.add(new Pair(newRow, newColumn));
                    }
                }
            }
        }

        return -1;
    }

    private boolean isEdge(Cell cell, int numberOfRows, int numberOfColumns) {
        if (cell.getRow() == 0 || cell.getColumn() == 0) {
            return true;
        } else if (cell.getRow() == numberOfRows -1 || cell.getColumn() == numberOfColumns - 1) {
            return true;
        }
        return false;
    }

    private boolean isValid(int row, int column, int numberOfRows, int numberOfColumns) {
        if (row < 0 || row >= numberOfRows) {
            return false;
        }

        if (column < 0 || column >= numberOfColumns) {
            return false;
        }

        return true;
    }

    private class Cell {
        private int row;
        private int column;
        private int level;

        public Cell() {

        }

        public Cell(int row, int column, int level) {
            this.row = row;
            this.column = column;
            this.level = level;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        public int getLevel() {
            return level;
        }
    }
}