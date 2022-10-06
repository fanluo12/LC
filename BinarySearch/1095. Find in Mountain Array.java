/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int left = 0, right = n - 1;
        
        // this will stop at peak position
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        
        // check if peak is the target
        int peak = left;
        if (mountainArr.get(peak) == target) {
            return peak;
        }
        
        // search from 0 to peak to find target
        left = 0;
        right = peak - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cur = mountainArr.get(mid);
            if (cur == target) {
                return mid;
            } 
            else if (cur > target){
                right = mid - 1;
            } 
            else {
                left = mid + 1;
            }
        }
        
        // search from peak
        left = peak + 1;
        right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cur = mountainArr.get(mid);
            if (cur == target) {
                return mid;
            } 
            else if (cur > target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
