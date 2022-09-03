## 332. Reconstruct Itinerary
Put each departure airport as key to hash map, and priority queue as its value. Add arrive airport to priority queue.
Use stack to update visited city. Push "JFK" to stack.
While stack is not empty, query the peek of stack. If map contains the peek airport, add its arrive airport from priority queue poll. Once all elements used up from hash map, put elements of stack to result list

## 1584. Min Cost to Connect All Points
User hash set to store visited index of points until size reaches points length
Define a helper function which calculate two points distance
Regard 0 index as start point, use distance array to represent distance. For loop through all elements with 0 index to find their distances.
Next we need to find shortest distance from distance array and marked this position as visited and then updated distance array, each index distance with this NEXT element. Remember to exclude visited points from set
