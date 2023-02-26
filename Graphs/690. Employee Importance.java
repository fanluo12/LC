/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        // idMap: [id, EMP]
        Map<Integer, Employee> idMap = new HashMap<>();
        for (int i = 0; i < employees.size(); i ++) {
            idMap.put(employees.get(i).id, employees.get(i));
        }

        // map: [EMP, List<EMP>]
        Map<Employee, List<Employee>> map = new HashMap<>();
        for (int i = 0; i < employees.size(); i ++) {
            map.putIfAbsent(employees.get(i), new ArrayList<>());
            for (int idOfSub: employees.get(i).subordinates) {
                map.get(employees.get(i)).add(idMap.get(idOfSub));
            }
        }
        int res = 0;
        Deque<Employee> queue = new LinkedList<>();
        queue.offer(idMap.get(id));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                Employee supervisor = queue.poll();
                for (Employee sub: map.get(supervisor)) {
                    queue.offer(sub);
                }
                res += supervisor.importance;
            }
        }
        return res;
    }
}
