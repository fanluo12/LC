class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int len1 = version1.length(), len2 = version2.length();
        
        // temporary updated result
        int tmp1 = 0, tmp2 = 0;
        while (i < len1 || j < len2) {
            tmp1 = 0;
            tmp2 = 0;
            while (i < len1 && version1.charAt(i) != '.') {
                tmp1 = tmp1 * 10 + (version1.charAt(i) - '0');
                i ++;
            }
            while (j < len2 && version2.charAt(j) != '.') {
                tmp2 = tmp2 * 10 + (version2.charAt(j) - '0');
                j ++;
            }
            if (tmp1 > tmp2) {
                return 1;
            }
            else if (tmp1 < tmp2) {
                return -1;
            }
            else {
                i ++;
                j ++;
            }
        }
        return 0;
    }
}
