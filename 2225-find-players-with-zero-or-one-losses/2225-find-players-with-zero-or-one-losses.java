class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<Integer> lostNoMatch = new ArrayList<>();
        List<Integer> lostOneMatch = new ArrayList<>();
        Map<Integer, Integer> matchesLost = new HashMap<>();
        Set<Integer> players = new HashSet<>();

        for (int i = 0; i < matches.length; i++) {
            players.add(matches[i][0]);
            players.add(matches[i][1]);

            matchesLost.put(matches[i][1], matchesLost.getOrDefault(matches[i][1], 0) + 1);
        }

        for (Integer player: players) {
            if (!matchesLost.containsKey(player)) {
                lostNoMatch.add(player);
            } else if (matchesLost.get(player) == 1) {
                lostOneMatch.add(player);
            }
        }
        
        Collections.sort(lostNoMatch);
        Collections.sort(lostOneMatch);

        return List.of(lostNoMatch, lostOneMatch);
    }
}