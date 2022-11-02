class Solution {
    
    int max = 0;
    
    public int maxLength(List<String> arr) {
        dfs(arr, "", 0);
        return max;
    }
    
    public void dfs(List<String> arr, String subArr, int start) {
        if (noDuplicate(subArr)) {
            max = Math.max(max, subArr.length());
        }
        if (start == arr.size() && !noDuplicate(subArr)) {
            return;
        }
        for (int i = start; i < arr.size(); i ++) {
            dfs(arr, subArr + arr.get(i), i + 1);
        }
    }
    
    public boolean noDuplicate(String s) {
        int[] charArr = new int[26];
        for (char c: s.toCharArray()) {
            charArr[c - 'a'] ++;
            if (charArr[c - 'a'] > 1) {
                return false;
            }
        }
        return true;
    } 
}
