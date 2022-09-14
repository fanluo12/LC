class Solution {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        
        backtrack(0, 0, "", s, res);
        return res;
    }
    
    public void backtrack(int leftIndex, int dots, String curIP, String s, List<String> res) {
        if (dots == 4 && leftIndex == s.length()) {
            res.add(curIP.substring(0, curIP.length() - 1));
            return;
        }
        for (int rightIndex = leftIndex; rightIndex < Math.min(leftIndex + 3, s.length()); rightIndex ++) {
            if (Integer.parseInt(s.substring(leftIndex, rightIndex + 1)) <= 255 && (leftIndex == rightIndex || s.charAt(leftIndex) != '0')) {
                backtrack(rightIndex + 1, dots + 1, curIP + s.substring(leftIndex, rightIndex + 1) + '.', s, res);
            }
        }
    }
}
