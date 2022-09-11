class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int index1 = 0, index2 = 0;
        int mid1 = 0, mid2 = 0;
        
        // loop through merged array to middle
        for (int i = 0; i <= (m + n) / 2; i ++) {
            mid1 = mid2;
            if (index1 == m) {
                mid2 = nums2[index2];
                index2 ++;
            }
            else if (index2 == n) {
                mid2 = nums1[index1];
                index1 ++;
            }
            else { // if two arrays left elements, traverse them
                if (nums1[index1] < nums2[index2]) {
                    mid2 = nums1[index1];
                    index1 ++;
                }
                else {
                    mid2 = nums2[index2];
                    index2 ++;
                }
            }
        }
        
        if ((m + n) % 2 == 0) {
            return (float)(mid1 + mid2) / 2;
        }
        return mid2;
    }
}
