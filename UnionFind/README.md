## 684. Redundant Connection
1. We populate array with index of each position
2. For each edge array, if find(start of edge) == find(end of edge), we return this edge, which means start has connect to end and become a circle. Each time finish looping, we use union function to update start index as end element
3. For find function, the KEY is to use while loop until get end of the edge.while (node != parent[node]) {node = parent[node];}, for example, with (1,2),(2,3),(3,4) the parent already be[0,2,3,4,4,5], so for next pair (1,4), with find function it will finally return to 4 which equals to 4, meaning circle detected and return
4. For union function, we simply update start index as end element
