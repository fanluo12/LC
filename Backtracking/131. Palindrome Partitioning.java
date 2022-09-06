class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), s, 0);
        return res;
    }
    
    public void backtrack(List<List<String>> res, List<String> path, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
        }
        
        for (int i = start; i < s.length(); i ++) {
            if (isPalindrome(s, start, i)) {
                path.add(s.substring(start, i + 1));
                backtrack(res, path, s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low ++) != s.charAt(high --)) {
                return false;
            }
        }
        return true;
    }
}
