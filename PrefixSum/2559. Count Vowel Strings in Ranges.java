class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] res = new int[queries.length];
        // prefix-sum array
        int[] prefixSum = new int[words.length];
        prefixSum[0] = isVowel(words[0]) ? 1 : 0;
        for (int i = 1; i < words.length; i ++) {
            prefixSum[i] = prefixSum[i - 1] + (isVowel(words[i]) ? 1: 0);
        }

        for (int i = 0; i < queries.length; i ++) {
            int left = queries[i][0], right = queries[i][1];
            res[i] = prefixSum[right] - (left == 0 ? 0 : prefixSum[left - 1]);
        }

        return res;
    }

    public boolean isVowel(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        if (set.contains(s.charAt(0)) && set.contains(s.charAt(s.length() - 1))) {
            return true;
        }
        return false;
    }
}
