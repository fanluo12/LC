class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int gift: gifts) {
            pq.offer(gift);
        }

        while (k > 0) {
            int max = pq.poll();
            pq.offer((int)Math.sqrt(max));
            k --;
        }
        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }
}
