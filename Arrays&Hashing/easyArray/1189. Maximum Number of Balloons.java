class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] charText = new int[26];
        int[] charBalloon = new int[26];
        for (char c: text.toCharArray()) {
            charText[c - 'a'] ++;
        }
        
        String ballon = "balloon";
        for (char c: ballon.toCharArray()) {
            charBalloon[c - 'a'] ++;
        }
        
        int min = Integer.MAX_VALUE;
        
        for (char c: ballon.toCharArray()) {
            min = Math.min(min, charText[c - 'a'] / charBalloon[c - 'a']);
        }
        return min;
    }
}
