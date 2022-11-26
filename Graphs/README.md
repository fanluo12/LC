# 17 total - 11/22/2022
## 126. Word Ladder II && 127. Word Ladder
### 126
1. Use hashset to store all the words from wordList and return empty list if endWord not in it
2. Since we want to return list of lists, we use hashmap to store <String, List<List<String>>> pair. For example, before BFS algorigthm, we should put <hit: [[hit]]>
3. Use BFS algorithm, each time we create a empty map called tmpMap which used to update result. The ideally result after first loop should be <hit: [[hit, hot]]>
4. When BFS, we first loop through keySets of map. If word from keySets equals to endWord, simply return map.get(word)
5. Then we need to substitute each digit. Loop through word length and for each index we loop from 'a' to 'z' to create newWord. If newWord not exists in hashset, continue to break single loop
6. If newWord, for example "hot" is one word of hashset, we need to take "hot" as key for tmpMap and get all the lists from map.get(word), which is ["hit"] and add newWord to it which becomes ["hit", "hot"]
7. After we got first round result, tmpMap = <"hot":[["hit", "hot"]]>, we don't need "hot" anymore and can remove from set. Also re-assign map to tmpMap since we don't need previous word
### 127
127 only needs to find length of word chain, so we basically have two ways to implement
1. Simple BFS. Use queue(which initiately offered beginWord) and result integer(res = 1) to do BFS. Each time for polled word, loop through each index and nested loop from 'a' to 'z' for newWord concatenation. Once newWord not in set which stores all the words from wordList, continue to break single loop. If exists but not exists in visited set, add to visited and queue
2. We use hashmap to store <pattern(h*t), [hot, hit,...]> to store patterns as key and all the words matches pattern as a list. Then simple BFS, if new concatenation word matches pattern, get all words in map.get(word) and add them to queue and visited set

## 200. Number of Islands
For loop through array once we meet "1"--island, we start dfs and update our result for each dfs.
For dfs function, first we need to mark visited island as "0" and search for 4 directions. If satisfy boundary criterias, keep searching

## 695. Max Area of Island
For loop through array when we meet island and search with dfs.
In dfs, once we out of boundry or current position is 0, we return 0. Then mark current position 0 as visited and search 4 directions

## 417. Pacific Atlantic Water Flow
Use 2 sets representing pacific and atlantic. Start from each ocean boundary and search for higher altitude inside and populate sets.
Finally cross check two sets' intersections.

## 130. Surrounded Regions
Start dfs from border, if border is 0 and connected 4 directions are 0, mark them as T.
For those non-T are just flip them. Finally flip T to O

## 994. Rotting Oranges
Count total fresh oranges and use minutes to update final result.
Use deque to input row and col of rotten orange.
While loop deque until its empty or still have fresh. Add new direction which could be rotten to deque

## 684. Redundant Connection
Use parent array to represent original from-to. Initialte parent as [0, 1, 2, 3...]
Find function, for input node, return what it should be in parent. For example, input is 2, we return parent[2]
Union function, given a and b input node, we find their output from parent, ie, parent[a] and parent[b]. If they are same, return. Else assign paren[a] = b
For each edge, first we find output from parent with find function. If they are same, for example, given [1, 2], [1, 3], [2, 3], after first two parent should be[0, 2, 3, 3...]. So for the last [2, 3], with find function, we find 3 == 3 then return this edge

## 289. Game of Life
Four states,
1. 0 -> 0
2. 1 -> 0
3. 0 -> 1
4. 1 -> 1
Define a helper function to count live neighbors for current index. Note we need to loop vertical, horizontal and diagnal directions, so loop would be [row - 1, row + 1], [col - 1, col + 1]. Once satisfy with corner situation and neighbor is 1 or 3(state 4: 1-> 1), update neighbor number.
Loop through all indices, for each index use method above to count neighbors. If current is 1 and neighbors is 2 or 3, make it to 3 for state 4. If current is 0 and neighbor is 3, mark as 2 for state 3.
Finally loop through matrix, put 1 to 0, put 3 to 1 and put 2 to 1

## 463. Island Perimeter
Loop through matrix, if matrix[r][c] == 1, result +4. If previous row or columns is also 1, then two of them connected would have a overlapped edge, so -2 if these situations


## 1905. Count Sub Islands
The key of this problem is to count idslands by dfs algorithm, we can use dfs to convert islands to water of grid2. It can be splitted to these steps:
1. If cell of grid1 is water while grid2 not, we need to use dfs to convert islands of grid2 to water since they definately cannot be counted as sub-islands of grid1
2. Once first filter finised, the left isilands of grid2 are the sub-islands. We need to count them with dfs method
3. Loop through rest grid2, once we find a island, use dfs to mark its connected place as 0 and update count

## 1958. Check if Move is Legal
We want to change (r, c) to one color such that this color be a end point of ONE good line(at least 3 cell and two end points colors are same). So take (rMove, cMove) stable, and search 8 directionally with dfs search. In dfs search, we need to calculate line length. While new row and col in boundaries, we grid[new row][new col] is same color with stable point, we check if length greater than 3

## 1091. Shortest Path in Binary Matrix
1. We use BFS to solve this problem and we mark visited 0 as 1 to avoid extra space
2. We use LinkedList to store[row, col, path]. In BFS, we poll out arr and once row and col reaches end of matrix, we return path
3. Then search 8 directionally, once satisfy boundary criterias and [new row, new col] is 1 rather 0, we offer them to queue and mark as 1
