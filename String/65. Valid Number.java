class Solution {
    public boolean isNumber(String s) {
        boolean digit = false, decimal = false, e = false, sign = false;
        
        for (char c: s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                digit = true;
            }
            else if (c == '+' || c == '-') {
                if (digit || sign || decimal) {
                    return false;
                }
                else {
                    sign = true;
                }
            }
            else if (c == 'E' || c == 'e') {
                if (!digit || e) {
                    return false;
                }
                else {
                    e = true;
                    sign = false;
                    digit = false;
                    decimal = false;
                }
            }
            else if (c == '.') {
                if (decimal || e) {
                    return false;
                }
                else {
                    decimal = true;
                }
            }
            else {
                return false;
            }
        }
        return digit;
    }
}
