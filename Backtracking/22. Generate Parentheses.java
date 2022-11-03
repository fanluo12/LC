class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i ++) {
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }
}

class Solution2 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack("", res, n, n);
        return res;
    }
    
    private void backtrack(String s, List<String> res, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(s);
        }
        if (left > 0) {
            backtrack(s + "(", res, left - 1, right);
        }
        if (right > left) {
            backtrack(s + ")", res, left, right - 1);
        }
    }
}
