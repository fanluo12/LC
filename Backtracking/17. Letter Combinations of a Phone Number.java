class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        List<String> res = new ArrayList<>();
        backtrack(res, digits, 0, "", map);
        return res;
    }
    
    public void backtrack(List<String> res, String digits, int index, String subString, HashMap<Character, String> map) {
        if (subString.length() == digits.length()) {
            res.add(subString);
            return;
        }
        
        for (char c: map.get(digits.charAt(index)).toCharArray()) {
            backtrack(res, digits, index + 1, subString + c, map);
        }
    }
    
}
