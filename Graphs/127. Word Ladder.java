class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for (String s: wordList) {
            set.add(s);
        }
        if (!set.contains(endWord)) {
            return 0;
        }
        
        HashMap<String, List<String>> map = new HashMap<>();
        for (String word: set) {
            for (int i = 0; i < word.length(); i ++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                map.putIfAbsent(pattern, new ArrayList<>());
                map.get(pattern).add(word);
            }
        }
        
        int res = 1;
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return res;
                }
                for (int j = 0; j < word.length(); j ++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    if (map.containsKey(pattern)) {
                        for (String allPatternWord: map.get(pattern)) {
                            if (!visited.contains(allPatternWord)) {
                                visited.add(allPatternWord);
                                queue.offer(allPatternWord);
                            }
                        }
                    }
                }
            }
            res ++;
        }
        return 0;
    }
}

// method2: common BFS. Too slow
class Solution2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        set.addAll(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        
        int res = 1;
        Deque<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return res;
                }
                for (int j = 0; j < word.length(); j ++) {
                    for (char c = 'a'; c <= 'z'; c ++) {
                        String newWord = word.substring(0, j) + c + word.substring(j  + 1);
                        if (!set.contains(newWord)) {
                            continue;
                        }
                        if (!visited.contains(newWord)) {
                            visited.add(newWord);
                            queue.offer(newWord);
                        }
                    }
                }
            }
            res ++;
        }
        return 0;
    }
}
