class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int h: hand) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (a - b));
        for (int h: map.keySet()) {
            pq.offer(h);
        }
        
        while (!pq.isEmpty()) {
            int start = pq.peek();
            for (int i = start; i < start + groupSize; i ++) {
                if (!map.containsKey(i)) {
                    return false;
                }
                map.put(i, map.getOrDefault(i, 0) - 1);
                if (map.get(i) == 0) {
                    pq.poll();
                }
            }
        }
        return true;
    }
}
