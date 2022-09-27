class Solution {
    public String frequencySort(String s) {
        char[] charArr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char i: charArr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> (a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue()));
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            pq.offer(entry);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!pq.isEmpty()) {
            Map.Entry tmp = pq.poll();
            for (int i = 0; i < (int)tmp.getValue(); i ++) {
                sb.append(tmp.getKey());
            }
        }
        return sb.toString();
    }
}
