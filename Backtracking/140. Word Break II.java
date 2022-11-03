class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        
        List<String> res = new ArrayList<>(); 
        backtrack(s, set, res, new ArrayList<>(), 0);
        return res;
    }
    
    public void backtrack(String s, Set<String> set, List<String> res, List<String> path, int start) {
        if (start == s.length()) {
            res.add(String.join(" ", path));
            return;
        }
        
        for (int i = start; i < s.length(); i ++) {
            String tmpStr = s.substring(start, i + 1);
            if (set.contains(tmpStr)) {
                path.add(tmpStr);
                backtrack(s, set, res, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
