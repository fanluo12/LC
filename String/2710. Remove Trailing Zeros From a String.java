class Solution {
    public String removeTrailingZeros(String num) {
        StringBuilder sb = new StringBuilder();
        int p = num.length();
        for (int i = num.length() - 1; i >= 0; i --) {
            if (num.charAt(i) != '0') {
                p = i;
                break;
            }
        }

        return num.substring(0, p + 1);
    }
}
