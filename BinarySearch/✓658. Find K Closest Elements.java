// method with binary search--little complicate
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i ++) {
            res.add(arr[i]);
        }
        return res;
    }
}

//
