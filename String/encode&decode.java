public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List<String> res = new ArrayList<>();
        int start = 0;

        while (start < str.length()) {
            int end = start;
            while (str.charAt(end) != '#') { // put end on # index
                end ++;
            }

            int length = Integer.valueOf(str.substring(start, end)); // get length of current String
            start = end + 1 + length;
            res.add(str.substring(end + 1, start));
        }

        return res;
    }
}
