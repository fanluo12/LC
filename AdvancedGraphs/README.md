# 14 total-10/21/2022

## 332. Reconstruct Itinerary
1. Put each departure airport as key to hash map, and priority queue as its value. Add arrive airport to priority queue.
2. Use stack to update visited city. Push "JFK" to stack.
3. While stack is not empty, query the peek of stack. If map contains the peek airport, add its arrive airport from priority queue poll. Once all elements used up from hash map, put elements of stack to result list

## 1584. Min Cost to Connect All Points
User hash set to store visited index of points until size reaches points length
Define a helper function which calculate two points distance
Regard 0 index as start point, use distance array to represent distance. For loop through all elements with 0 index to find their distances.
Next we need to find shortest distance from distance array and marked this position as visited and then updated distance array, each index distance with this NEXT element. Remember to exclude visited points from set

## 778. Swim in Rising Water
Use priority queue to store array[time used, row index, column index]
User hash set to mark visited position
while(!pq.isEmpty()) loop. When polled row and column index reaches end simply return time used.
For loop through 4 directions and put max time of one direction to pq.

## 787. Cheapest Flights Within K Stops
Create a array called prices and populate array with MAX_VALUE for updating cheapest prices and marking visited. Initiate src city as 0.
For loop through until k times since we want to stop k times then total would be k + 1 stop. 
Each time we looping we start a new looping through all flights information to find a cheap way. The idea is updating cheaper prices for prices[s] + cost. At first, one result will surely less than MAX_VALUE, then other result would less than this one if there has. If src city is MAX_VALUE, we just continue to jump over it. Remember each time we loop flights, we need to deep copy original prices and assign back when flights loop done

## 207. Course Schedule
Use list to store all courses. For each pre-course, add its children course to list. Loop through courses, if dfs function return false then return false
For dfs function, we start to search from first course and mark it as 1--visited. We get its children courses, ie only take children courses you have to take this course, and iterate children courses. Once children course marked 1, means dead loop and return false. If children is 0, which means not visited, dfs from here and when dfs return false simply return false. Finally we mark this course as 2--done visiting

## 399. Evaluate Division
Use map<String, map<String, Double>> to store current equations. For a/b = 2.0, not only put a:[b:2.0] but also put b[a: 0.5] to map.
Use DFS function to find each queries results. For DFS function, we need to judge if map contains x or y as key or not, if not return -1. Then we get all divisors(map format)xMap of x. If xMap contains y, then return xMap.get(y). If not, for loop through xMap key sets and use hash set to avoid dead cycle. Use tmp to find key and y's result with DFS function, ie tmp = DFS(key of xMap, y). If cannot depth search which means tmp is -1, continue for other key sets, else return tmp * xMap.get(key)

## 863. All Nodes Distance K in Binary Tree
1. Use helper function to convert tree to graph, ie put node as key to map, and its parent and children to array list as values.
2. Use BFS to search. First use queue to store target, and minus k each time when polling. While polling, find values from map and add to queue

## 934. Shortest Bridge
1. We loop through each unit of grid, ONCE we find a island, we use dfs search to expand its connected island and marked visited unit as true. This idea is not same with fill boolean array with ture if island is 1, we need to search from one island, expand to its largest island, and use bfs to search another island
2. Once we find unit island and dfs method to fill boolean array, we use bfs method. First we put all true unit in boolean array to queue, and use bfs search 4 directionally if in boundary or not visited. Once new unit is 1, we return result, else after each 4 directionally search we update 1 to result

## 1293. Shortest Path in a Grid with Obstacles Elimination
1. Use queue to store (row, col, steps) and initialze queue with [0, 0, 0]
2. Use integer array representing visited optimal way, initialize (0, 0) as 0 and rest as inf
3. BFS method with queue, each time poll array out. Once row and col reaches end, return steps. For 4 directions, continue when out of boundary, continue when steps + (new row, new col) greater than k, continue when there is optimal result for new row and new col(visited[new row][new col] <= new k). Then assign (new row, new col, new k) to queue and visited[new row][new col] = new k

## 1376. Time Needed to Inform All Employees
We can either BFS or DFS
1. For both method, first we need to create a hashmap which store key: manager[i], value: list of i, ie subordinates
2. Use queue to store pair (headId, time which initialize as 0). Do BFS search, each time when we poll out, we update result time with max of itself and polled time. Then we get list of current polled manage level by map, and add back to subordiates of list, and cumulated time to queue again

## 1466. Reorder Routes to Make All Paths Lead to the City Zero
We store all the (from, to) to hashmap. If direction is right, we store [to, 1] as value of from since if we changes back this route it will update 1 to result. So for the reverse direction we will sotre [from, 0] since we don't need to reverse. We use hashset to start dfs searching from begin city. At dfs function, we first add city to hashset, and for loop through all the connected city pairs in hashmap, add its route value to result

## 802. Find Eventual Safe States
1. We create integer array safe where safe[i] = 2 representing finally safe, and safe[i] = 1 representing not safe. Loop through graph, use dfs helper function, if ith node is safe, add it to result list
2. In dfs function, we first judge if safe[i] == 2 => return true and safe[i] == 1 => return false. We mark safe[i] as 1 which means visiting and get its sub-routes array. We loop through sub-routes array and use dfs function to judge. Finally we mark safe[i] as 2 and return true
