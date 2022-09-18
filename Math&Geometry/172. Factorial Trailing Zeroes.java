class Solution {
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        int res = 0;
        // if there is one 5, then must one responding 0
        // so we count how many 5 it has
        while (n > 0) {
            n /= 5;
            res += n;
        }
        return res;
    }
}
