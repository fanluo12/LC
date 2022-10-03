class Solution {
    public int minFlipsMonoIncr(String s) {
        int zero = 0;
        for (char c: s.toCharArray()) {
            if (c == '0') {
                zero += 1;
            }
        }
        int one = 0;
        int res = zero;
        
        for (char c: s.toCharArray()) {
            if (c == '0') {
                zero -= 1;
            }
            else {
                one += 1;
            }
            res = Math.min(res, zero + one);
        }
        return res;
    }
}
