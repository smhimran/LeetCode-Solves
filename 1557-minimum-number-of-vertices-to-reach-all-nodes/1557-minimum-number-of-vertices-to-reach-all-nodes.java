class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Map<Integer, Integer> inDegreeMap = new HashMap<>();

        edges.forEach(edge -> inDegreeMap.merge(edge.get(1), 1, Integer::sum));

        return IntStream.range(0, n)
                            .filter(i -> !inDegreeMap.containsKey(i))
                            .boxed()
                            .collect(Collectors.toList());
    }
}