class Solution {
    public int minCost(String colors, int[] neededTime) {
        int previousIndex = 0;
        int cost = 0;
    
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(previousIndex)) {
                int minimumCost;
                if (neededTime[previousIndex] < neededTime[i]) {
                    minimumCost = neededTime[previousIndex];
                    previousIndex = i;
                } else {
                    minimumCost = neededTime[i];
                }
                cost += minimumCost;
            } else {
                previousIndex = i;
            }
        }

        return cost;
    }
}