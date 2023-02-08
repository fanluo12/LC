class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        // arr[0] -> id, arr[1] -> score
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? Integer.compare(a[0],b[0]) : Integer.compare(b[1],a[1]));
        // use two feedback set to check if words contains pos or neg
        Set<String> pos = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> neg = new HashSet<>(Arrays.asList(negative_feedback));

        int length = student_id.length;
        for (int i = 0; i < length; i ++) {
            int score = getScore(report[i], pos, neg);
            pq.offer(new int[]{student_id[i], score});
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll()[0]);
            k --;
            if (k == 0) {
                break;
            }
        }
        return res;
    }

    public int getScore(String s, Set<String> pos, Set<String> neg) {
        int score = 0;
        String[] strArr = s.split(" ");
        for (String str: strArr) {
            if (pos.contains(str)) {
                score += 3;
            }
            else if (neg.contains(str)) {
                score --;
            }
        }
        return score;
    }
}
