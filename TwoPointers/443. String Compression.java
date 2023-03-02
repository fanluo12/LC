class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        
        int finalIndex = 0, p = 0;
        while (p < chars.length) {
            char cur = chars[p];
            int count = 0;
            while (p < chars.length && chars[p] == cur) {
                p ++;
                count ++;
            }
            chars[finalIndex] = cur;
            finalIndex ++;
            if (count != 1) {
                for (char c: Integer.toString(count).toCharArray()) {
                    chars[finalIndex] = c;
                    finalIndex ++;
                }
            }
        }
        return finalIndex;
    }
}
