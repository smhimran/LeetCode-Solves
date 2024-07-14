class Solution {
public:
    static int distance(const std::vector<int>& a) {
        return a[0] * a[0] + a[1] * a[1];
    }

    static bool compare(vector<int> a, vector<int> b) {
        return distance(a) < distance(b);
    }

    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        sort(points.begin(), points.end(), compare);

        vector<vector<int>> nearestPoints;
        
        for (int i = 0; i < k; i++) {
            nearestPoints.push_back(points[i]);
        }

        return nearestPoints;
    }
};