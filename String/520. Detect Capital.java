class Solution {
    public boolean detectCapitalUse(String word) {
        int capitals = 0;
        for (char c: word.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                capitals ++;
            }
            
        }
        if (capitals == word.length() || capitals == 0) {
            return true;
        }
        return capitals == 1 && (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z');
    }
}
