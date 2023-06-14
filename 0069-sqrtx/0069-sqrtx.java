class Solution {
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }

        double low = 0;
        double high = (double) x;
        double ret = 0;

        while (low < high) {
            double mid = (low + high) / 2.0;
            double square = mid * mid;

            if (Math.abs(square - x) < 1e-5) {
                ret = mid;
                break;
            } else if (square < x) {
                low = mid;
            } else {
                high = mid;
            }
        }

        System.out.println(ret);

        return (int) ret;
    }
}