class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        for (int i = length / 2; i >= 1; i --) {
            if (length % i == 0) { // if current section can be copied
                int cut = length / i;
                String tmp = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < cut; j ++) {
                    sb.append(tmp);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }

        return false;
    }
}
