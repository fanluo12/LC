class Solution {
    public String longestDiverseString(int a, int b, int c) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', a);
        map.put('b', b);
        map.put('c', c);
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((x, y) -> (y.getValue() - x.getValue()));
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() != 0) {
                pq.offer(entry);
            }
        }
        
        StringBuilder res = new StringBuilder();
        
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            char c1 = entry.getKey();
            int count1 = entry.getValue();
            int len = res.length();
            if (len > 1 && res.charAt(len - 1) == c1 && res.charAt(len - 2) == c1 && res.charAt(len - 1) == res.charAt(len - 2)) {
                if (pq.isEmpty()) {
                    break;
                }
                Map.Entry<Character, Integer> entry2 = pq.poll();
                char c2 = entry2.getKey();
                int count2 = entry2.getValue();
                res.append(c2);
                count2 --;
                if (count2 > 0) {
                    entry2.setValue(count2);
                    pq.offer(entry2);
                }
            }
            else {
                res.append(c1);
                count1 --;
            }
            if (count1 > 0) {
                entry.setValue(count1);
                pq.offer(entry);
            }
        }
        return res.toString();
    }
}
