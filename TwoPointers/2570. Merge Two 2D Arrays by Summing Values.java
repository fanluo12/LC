class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int p1 = 0, p2 = 0;
        List<List<Integer>> list = new ArrayList<>();

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1][0] == nums2[p2][0]) {
                list.add(Arrays.asList(nums1[p1][0], nums1[p1][1] + nums2[p2][1]));
                p1 ++;
                p2 ++;
            }
            else if (nums1[p1][0] < nums2[p2][0]) {
                list.add(Arrays.asList(nums1[p1][0], nums1[p1][1]));
                p1 ++;
            }
            else {
                list.add(Arrays.asList(nums2[p2][0], nums2[p2][1]));
                p2 ++;
            }
        }

        while (p1 != nums1.length) {
            list.add(Arrays.asList(nums1[p1][0], nums1[p1][1]));
            p1 ++;
        }
        while (p2 != nums2.length) {
            list.add(Arrays.asList(nums2[p2][0], nums2[p2][1]));
            p2 ++;
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i ++) {
            res[i][0] = list.get(i).get(0);
            res[i][1] = list.get(i).get(1);
        }

        return res;
    }
}
