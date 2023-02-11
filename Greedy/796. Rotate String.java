class Solution {
    public boolean rotateString(String s, String goal) {
        int length = s.length();
        String greedyString = s + s;
        
        for (int i = 0; i < length; i ++) {
            if (greedyString.substring(i, i + length).equals(goal)) {
                return true;
            }
        }
        return false;
    }
}
