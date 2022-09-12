class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int m = words.length;
        int n = words[0].length();
        List<Integer> res = new ArrayList<>();
        
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        // in case start substring not comes from exactly integer times n
        // for example, word = foo, the while string = "abfoothe"
        for (int i = 0; i < n; i ++) {
            int left = i;
            HashMap<String, Integer> subMap = new HashMap<>();
            int count = 0;
            
            for (int j = i; j < s.length() - n + 1; j += n) {
                String w = s.substring(j, j + n);
                if (map.containsKey(w)) {
                    subMap.put(w, subMap.getOrDefault(w, 0) + 1);
                    count += 1;
                    while (subMap.get(w) > map.get(w)) {
                        subMap.put(s.substring(left, left + n), subMap.getOrDefault(s.substring(left, left + n), 0) - 1);
                        left += n;
                        count -= 1;
                    }
                    if (count == m) {
                        res.add(left);
                    }
                } else {
                    left = j + n;
                    subMap = new HashMap<>();
                    count = 0;
                }
            }
        }
        return res;
    }
}
