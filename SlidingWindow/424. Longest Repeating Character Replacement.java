class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, max = 0;
        int res = 0;
        for (int right = 0; right < s.length(); right ++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            max = Math.max(max, map.get(s.charAt(right)));
            
            while (right - left + 1 > max + k) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                left ++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
// faster and more concise
class Solution2 {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        
        for (int end = 0; end < s.length(); end ++) {
            count[s.charAt(end) - 'A'] ++;
            maxCount = Math.max(maxCount, count[s.charAt(end) - 'A']);
            // end - start + 1 is the current window size, if it minus maxCount == 0 means window filled with same characters
            // however, if windowSize - maxCount > 0 means OTHER characrers are mixed. If it is greater than k, means we need to remove some of them until k to shrink window
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A'] --;
                start ++;
            }
            // The shrinked window may invalid at some points, but it doesn't matter since it was already valid in the begining part before other where in string
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
