class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        char[] charArr = s.toCharArray();
        int left = 0, right = removable.length - 1;
        
        while (left <= right) {
            // mid represent how many characters been removed this round
            int mid = left + (right - left) / 2;
            // remove these characters
            for (int i = 0; i <= mid; i ++) {
                charArr[removable[i]] = '*';
            }
            // if p still subsequences of s, update left
            if (valid(charArr, p)) {
                left = mid + 1;
            }
            // else we give back those removed characters
            else {
                for (int i = 0; i <= mid; i ++) {
                    charArr[removable[i]] = s.charAt(removable[i]);
                    right = mid - 1;
                }
            }
        }
        return left;
    }
    
    private boolean valid(char charArr[], String p) {
        int i = 0, j = 0;
        while(i < charArr.length && j < p.length()) {
            if (charArr[i] == p.charAt(j)) {
                j ++;
            }
            i ++;
        }
        return j == p.length();
    }
}
