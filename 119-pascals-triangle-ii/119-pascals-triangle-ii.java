class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> row = new ArrayList<>();

        row.add(new ArrayList<>());
        row.add(new ArrayList<>());

        row.get(0).add(1);
        row.get(1).add(1);
        row.get(1).add(1);

        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> currentRow = new ArrayList<>();
            List<Integer> previousRow = row.get((i - 1) % 2);

            int previousNumber = previousRow.get(0);

            currentRow.add(1);

            for (int j = 1; j < previousRow.size(); j++) {
                int now = previousRow.get(j);
                currentRow.add(previousNumber + now);
                previousNumber = now;
            }

            currentRow.add(1);
            row.set(i % 2, currentRow);
        }

        return row.get(rowIndex % 2);
    }
}