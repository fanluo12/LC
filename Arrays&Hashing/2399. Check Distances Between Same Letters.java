class Solution {
    public boolean checkDistances(String s, int[] distance) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }

        for (char c: map.keySet()) {
            if (distance[c - 'a'] != map.get(c).get(1) - map.get(c).get(0) - 1) {
                return false;
            }
        }
        return true;
    }
}
