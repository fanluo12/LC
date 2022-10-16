class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] prevStatus = new int[n];
        int max = 0, leftIndex = -1;
        
        Arrays.sort(nums);
        
        for (int right = 0; right < n; right ++) {
            count[right] = 1;
            prevStatus[right] = -1;
            
            for (int left = right - 1; left >= 0; left --) {
                if (nums[right] % nums[left] == 0 && count[left] + 1 > count[right]) {
                    count[right] = count[left] + 1;
                    prevStatus[right] = left;
                } 
            }
            if (count[right] > max) {
                max = count[right];
                leftIndex = right;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while (leftIndex != -1) {
            res.add(0, nums[leftIndex]);
            leftIndex = prevStatus[leftIndex];
        }
        return res;
    }
}
