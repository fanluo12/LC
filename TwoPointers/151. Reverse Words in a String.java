class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        //1. reverse whole string
        reverseWholeString(a, 0, n - 1);
        //2 reverse each word
        reverseWords(a, n);
        //3. remove spaces
        return removeSpaces(a, n);
        
    }
    
    public void reverseWholeString(char[] a, int left, int right) {
        while (left < right) {
            char tmp = a[left];
            a[left ++] = a[right];
            a[right --] = tmp;
        }
    }
    
    public void reverseWords(char[] a, int n) {
        int left = 0, right = 0;
        while (left < n) {
            // jump over spaces until first character
            while (left < right || (left < n  && a[left] == ' ')) {
                left ++;
            }
            // update right to left place and iterate current string
            while (right < left || (right < n && a[right] != ' ')) {
                right ++;
            }
            reverseWholeString(a, left, right - 1);
        }
    }
    
    public String removeSpaces(char[] a, int n) {
        int left = 0, right = 0;
        while (right < n) {
            // remove leading spaces
            while (right < n && a[right] == ' ') {
                right ++;
            }
            // substitute left leading spaces with string
            while (right < n && a[right] != ' ') {
                a[left ++] = a[right ++];
            }
            // remove middle multiple spaces
            while (right < n && a[right] == ' ') {
                right ++;
            }
            // remove trailing spaces;
            if (right < n) {
                a[left ++] = ' ';
            }
        }
        return new String(a).substring(0, left);
    }
}
