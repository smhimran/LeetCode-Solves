class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> fruitFrequency = new HashMap<>();
        List<Integer> fruitsTaken = new ArrayList<>();

        int maximumFruits = 0, numberOfUniqueFruits = 0;

        for (int i = 0; i < fruits.length; i++) {
            fruitsTaken.add(fruits[i]);
            
            if (fruitFrequency.containsKey(fruits[i])) {
                int previousFrequency = fruitFrequency.get(fruits[i]);
                fruitFrequency.put(fruits[i], previousFrequency + 1);
            } else {
                numberOfUniqueFruits++;
                fruitFrequency.put(fruits[i], 1);
            }

            while (numberOfUniqueFruits > 2) {
                int fruitAtFront = fruitsTaken.get(0);
                fruitsTaken.remove(0);
                
                int currentFrequency = fruitFrequency.get(fruitAtFront);

                if (currentFrequency == 1) {
                    fruitFrequency.remove(fruitAtFront);
                    numberOfUniqueFruits--;
                } else {
                    fruitFrequency.put(fruitAtFront, currentFrequency - 1);
                }
            }

            maximumFruits = Math.max(maximumFruits, fruitsTaken.size());
        }

        return maximumFruits;
    }
}