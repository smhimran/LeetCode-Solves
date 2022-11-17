class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = ((ax2 - ax1) * (ay2 - ay1));
        int area2 = ((bx2 - bx1) * (by2 - by1));

        int cx1 = Math.max(ax1, bx1);
        int cy1 = Math.max(ay1, by1);

        int cx2 = Math.min(ax2, bx2);
        int cy2 = Math.min(ay2, by2);
        
        int side1 = cx2 - cx1;
        int side2 = cy2 - cy1;

        int overlappedArea = ((cx2 - cx1) * (cy2 - cy1));

        int totalArea = area1 + area2;

        if (side1 > 0 && side2 > 0) {
            totalArea -= overlappedArea;
        }

        return totalArea;
    }
}