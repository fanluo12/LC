class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket: tickets) {
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).offer(ticket.get(1));
        }
        
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        
        List<String> res = new ArrayList<>();
        
        while (!stack.empty()) {
            String next = stack.peek();
            if (map.containsKey(next) && map.get(next).size() > 0) {
                stack.push(map.get(next).poll());
            }
            else {
                res.add(0, stack.pop());
            }
        }
        return res;
    }
}
