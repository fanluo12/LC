class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        backtrack(num, target, res, "", 0, 0, 0);
        return res;
    }
    
    public void backtrack(String num, int target, List<String> res, String path, int start, long prevSum, long multi) {
        if (start == num.length() && target == prevSum) {
            res.add(path);
            return;
        }
        
        for (int i = start; i < num.length(); i ++) {
            if (i != start && num.charAt(start) == '0') {
                break;
            }
            long curSum = Long.parseLong(num.substring(start, i + 1));
            if (start == 0) {
                backtrack(num, target, res, path + curSum, i + 1, curSum, curSum);
            }
            else {
                backtrack(num, target, res, path + "+" + curSum, i + 1, prevSum + curSum, curSum);
                backtrack(num, target, res, path + "-" + curSum, i + 1, prevSum - curSum, -curSum);
                backtrack(num, target, res, path + "*" + curSum, i + 1, prevSum - multi + curSum * multi, multi * curSum);
                
            }
        }
    }
}
