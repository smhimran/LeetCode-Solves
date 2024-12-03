class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        int flowersPlaced = 0;

        for (int i = 0; i < flowerbed.size(); i++) {
            if (flowerbed[i] == 0 and possibleToPlaceFlower(i, flowerbed)) {
                flowerbed[i] = 1;
                flowersPlaced++;
            }
        }

        return flowersPlaced >= n;
    }

    bool possibleToPlaceFlower(int i, vector<int>& flowerbed) {
        if (i - 1 >= 0 and flowerbed[i - 1] == 1) 
            return false;
        
        if (i + 1 < flowerbed.size() and flowerbed[i + 1] == 1) 
            return false;
        
        return true;
    }
};