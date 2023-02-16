class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int index = num.length - 1, carry = 0;

        while (index >= 0 || k != 0 || carry == 1) {
            int digit = 0;
            if (index >= 0) {
                digit += num[index];
                index --;
            }
            if (k != 0) {
                digit += k % 10;
                k /= 10;
            }
            digit += carry;
            res.add(0, digit % 10);
            carry = digit / 10;
        }
        return res;
    }
}
