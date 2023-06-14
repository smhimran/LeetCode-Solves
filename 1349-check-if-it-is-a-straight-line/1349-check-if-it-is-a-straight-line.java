class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        boolean isStraightLine = true;
        double expectedSlope = slope(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1]);

        for (int i = 2; i < coordinates.length; i++) {
            double currentSlope = slope(coordinates[i - 1][0], coordinates[i - 1][1], coordinates[i][0], coordinates[i][1]);
            
            if (currentSlope != expectedSlope) {
                isStraightLine = false;
            }
        }

        return isStraightLine;
    }

    private double slope(int x1, int y1, int x2, int y2) {
        if (x2 - x1 == 0) {
            return Integer.MAX_VALUE;
        }

        return (double) (y2 - y1) / (x2 - x1);
    }
}