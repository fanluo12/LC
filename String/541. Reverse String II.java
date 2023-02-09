class Solution {
    public String reverseStr(String s, int k) {
        int finalStart = s.length() - s.length() % (2 * k);
        int finalLength = s.length() - 1 - finalStart + 1;
        
        char[] arr = s.toCharArray();
        for (int i = 0; i < finalStart; i += 2 * k) {
            reverse(arr, i, i + k - 1);
        }

        if (finalLength < k) {
            reverse(arr, finalStart, s.length() - 1);
        }
        else {
            reverse(arr, finalStart, finalStart + k - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (char c: arr) {
            sb.append(c);
        }
        return sb.toString();
        
    }

    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left ++;
            right --;
        }
    }
}
