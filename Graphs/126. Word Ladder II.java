class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        set.addAll(wordList);
        if (!set.contains(endWord)) {
            return new ArrayList<>();
        }
        
        HashMap<String, List<List<String>>> map = new HashMap<>();
        map.put(beginWord, new ArrayList<>());
        map.get(beginWord).add(new ArrayList<>(Arrays.asList(beginWord)));
        
        while (!map.isEmpty()) {
            HashMap<String, List<List<String>>> tmpMap = new HashMap<>();
            for (String word: map.keySet()) {
                if (word.equals(endWord)) {
                    return map.get(word);
                }
                for (int i = 0; i < word.length(); i ++) {
                    for (char c = 'a'; c < 'a' + 26; c ++) {
                        String newWord = word.substring(0, i) + c + word.substring(i + 1);
                        if (!set.contains(newWord)) {
                            continue;
                        }
                        if (!tmpMap.containsKey(newWord)) {
                            tmpMap.put(newWord, new ArrayList<>());
                        }
                        for (List<String> list: map.get(word)) {
                            List<String> newList = new ArrayList<>(list);
                            newList.add(newWord);
                            tmpMap.get(newWord).add(newList);
                        }
                    }
                }
            }
            map = tmpMap;
            for (String str: tmpMap.keySet()) {
                set.remove(str);
            }
        }
        return new ArrayList<>();
    }
}
