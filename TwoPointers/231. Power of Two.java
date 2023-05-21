class Solution {
    public String makeSmallestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        char[] arr = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                if (arr[left] < arr[right]) {
                    arr[right] = arr[left];
                }
                else {
                    arr[left] = arr[right];
                }
            }
            left ++;
            right --;
        }

        StringBuilder sb = new StringBuilder();
        for (char c: arr) {
            sb.append(c);
        }
        return sb.toString();
    }
}
