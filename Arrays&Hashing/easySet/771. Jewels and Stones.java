class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> setJ = new HashSet<>();
        for (char c: jewels.toCharArray()) {
            setJ.add(c);
        }
        
        int sum = 0;
        
        for (char s: stones.toCharArray()) {
            if (setJ.contains(s)) {
                sum += 1;
            }
        }
        return sum;
    }
}

// method2: char array
class Solution2 {
    public int numJewelsInStones(String jewels, String stones) {
        int[] charArr = new int[256];
        for (char c: jewels.toCharArray()) {
            charArr[c] ++;
        }
        
        int res = 0;
        for (char c: stones.toCharArray()) {
            if (charArr[c] != 0) {
                res += charArr[c];
            }
        }
        return res;
    }
}
