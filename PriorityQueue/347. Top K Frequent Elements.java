class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.offer(entry);
        }
        
        int[] res = new int[k];
        for (int i = 0; i < k; i ++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}
