class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (score[b] - score[a]));
        for (int i = 0; i < score.length; i ++) {
            pq.offer(i);
        }
        
        String[] res = new String[score.length];
        if (pq.size() == 1) {
            res[pq.poll()] = "Gold Medal";
        }
        else if (pq.size() == 2) {
            res[pq.poll()] = "Gold Medal";
            res[pq.poll()] = "Silver Medal";
        }
        else if (pq.size() == 3) {
            res[pq.poll()] = "Gold Medal";
            res[pq.poll()] = "Silver Medal";
            res[pq.poll()] = "Bronze Medal";
        }
        else {
            res[pq.poll()] = "Gold Medal";
            res[pq.poll()] = "Silver Medal";
            res[pq.poll()] = "Bronze Medal";
            for (int i = 3; i < score.length; i ++) {
                res[pq.poll()] = Integer.toString(i + 1);
            }
        }
        return res;
    }
}
