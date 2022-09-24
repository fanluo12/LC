class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n1: nums1) {
            map.put(n1, map.getOrDefault(n1, 0) + 1);
        }
        
        List<Integer> duplicateList = new ArrayList<>();
        for (int n2: nums2) {
            if (map.containsKey(n2) && map.get(n2) > 0) {
                duplicateList.add(n2);
                map.put(n2, map.getOrDefault(n2, 0) - 1);
            }
        }
        
        int[] result = new int[duplicateList.size()];
        for(int i = 0; i < duplicateList.size();i++){
            result[i] = duplicateList.get(i);
        }
        return result;
    }
}
