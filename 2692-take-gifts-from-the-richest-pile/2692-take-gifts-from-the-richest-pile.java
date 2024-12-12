class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long remainingGifts = 0L;

        for (int gift: gifts) {
            pq.add(gift);
        }

        while (!pq.isEmpty() &&  k > 0) {
            int current = pq.poll();
            int remaining = (int)(Math.floor(Math.sqrt(current)));
            pq.add(remaining);
            k--;
        }

        while (!pq.isEmpty()) {
            remainingGifts += pq.poll();
        }

        return remainingGifts;
    }
}