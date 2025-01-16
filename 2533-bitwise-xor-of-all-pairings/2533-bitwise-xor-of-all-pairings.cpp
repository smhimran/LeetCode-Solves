class Solution {
public:
    int xorAllNums(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int, long long> frequency;
        int answer = 0;

        int length1 = nums1.size();
        int length2 = nums2.size();

        for (int i: nums1) {
            frequency[i] += length2;
        }

        for (int i: nums2) {
            frequency[i] += length1;
        }

        for (auto& [number, count]: frequency) {
            if (count & 1) {
                answer ^= number;
            }
        }

        return answer;
    }
};