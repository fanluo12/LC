class Solution {
    public String pushDominoes(String dominoes) {
        char[] dom = dominoes.toCharArray();
        Deque<Pair<Integer, Character>> queue = new ArrayDeque<>();
        for (int i = 0; i < dom.length; i ++) {
            if (dom[i] != '.') {
                queue.offer(new Pair(i, dom[i]));
            }
        }
        
        while (!queue.isEmpty()) {
            Pair<Integer, Character> tmp = queue.poll();
            int index = tmp.getKey();
            char c = tmp.getValue();
            if (c == 'L' && index > 0 && dom[index - 1] == '.') {
                queue.offer(new Pair(index - 1, 'L'));
                dom[index - 1] = 'L';
            }
            else if (c == 'R') {
                if (index + 1 < dom.length && dom[index + 1] == '.') {
                    if (index + 2 < dom.length && dom[index + 2] == 'L') {
                        queue.poll();
                    }
                    else {
                        queue.offer(new Pair(index + 1, 'R'));
                        dom[index + 1] = 'R';
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : dom) {
            sb.append(c);
        }
        return sb.toString();
    }
}
