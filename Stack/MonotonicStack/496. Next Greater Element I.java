class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i ++) {
            map.put(nums1[i], i);
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        
        for (int i = 0; i < nums2.length; i ++) {
            int cur = nums2[i];
            
            while (!stack.empty() && stack.peek() < nums2[i]) {
                int val = stack.pop();
                int idx = map.get(val);
                res[idx] = cur;
            }
            
            if (map.containsKey(cur)) {
                stack.push(cur);
            }
        }
        return res;
    }
}
