class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        set.addAll(wordDict);
        
        List<String> res = new ArrayList<>();
        backtrack(s, 0, res, set, new ArrayList<>());
        return res;
    }
    
    public void backtrack(String s, int start, List<String> res, HashSet<String> set, List<String> path) {
        if (start == s.length()) {
            res.add(String.join(" ", path));
            return;
        }
        
        for (int i = start + 1; i < s.length() + 1; i ++) {
            String curStr = s.substring(start, i) ;
            if (set.contains(curStr)) {
                path.add(curStr);
                backtrack(s, i, res, set, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
