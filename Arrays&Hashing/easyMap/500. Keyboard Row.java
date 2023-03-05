class Solution {
    public String[] findWords(String[] words) {
        String s1 = "qwertyuiop";
        String s2 = "asdfghjkl";
        String s3 = "zxcvbnm";
        Map<Character, Integer> keyboard = new HashMap<>();

        for (char c: s1.toCharArray()) {
            keyboard.put(c, 1);
        }
        for (char c: s2.toCharArray()) {
            keyboard.put(c, 2);
        }
        for (char c: s3.toCharArray()) {
            keyboard.put(c, 3);
        }

        List<String> listOfStrings = new ArrayList<>();
        for (String word: words) {
            int flag = keyboard.get(Character.toLowerCase(word.charAt(0)));
            for (int i = 1; i < word.length(); i ++) {
                if (keyboard.get(Character.toLowerCase(word.charAt(i))) != flag) {
                    flag = -1;
                    break;
                }
            }
            if (flag == -1) {
                continue;
            }
            else {
                listOfStrings.add(word);
            }
        }

        String[] res = new String[listOfStrings.size()];
        for (int i = 0; i < listOfStrings.size(); i ++) {
            res[i] = listOfStrings.get(i);
        }
        return res;
        
    }
}
