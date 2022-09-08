class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        String[] strArr = new String[numRows];
        for (int i = 0; i < numRows; i ++) {
            strArr[i] = "";
        }
        
        int row = 0, direction = 0;
        for (char c: s.toCharArray()) {
            if (row == 0) {
                direction = 1;
            }
            if (row == numRows - 1) {
                direction = -1;
            }
            strArr[row] += c;
            row += direction;
        }
        
        StringBuilder sb = new StringBuilder();
        for (String str: strArr) {
            sb.append(str);
        }
        return sb.toString();
    }
}
