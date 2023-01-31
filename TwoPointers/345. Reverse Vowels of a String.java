class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            // find first left vowel
            while (left < right && !set.contains(arr[left])) {
                left ++;
            }
            // find first right vowel
            while (left < right && !set.contains(arr[right])) {
                right --;
            }
            // swap
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;

            left ++;
            right --;
        }
        return new String(arr);
    }

}
