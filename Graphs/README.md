# 16 total - 11/30/2022
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

## 130. Surrounded Regions
Start dfs from border, if border is 0 and connected 4 directions are 0, mark them as T.
For those non-T are just flip them. Finally flip T to O
  
## 200. Number of Islands && 1905. Count Sub Islands
Both question uses dfs method to mark islands to water, and in this way to find connecter islands
### 200
For loop through array once we meet "1"--island, we start dfs and update our result for each dfs.
For dfs function, first we need to mark visited island as "0" and search for 4 directions. If satisfy boundary criterias, keep searching
## 1905
The key of this problem is to count idslands by dfs algorithm, we can use dfs to convert islands to water of grid2. It can be splitted to these steps:
1. If cell of grid1 is water while grid2 not, we need to use dfs to convert islands of grid2 to water since they definately cannot be counted as sub-islands of grid1
2. Once first filter finised, the left isilands of grid2 are the sub-islands. We need to count them with dfs method
3. Loop through rest grid2, once we find a island, use dfs to mark its connected place as 0 and update count

## 289. Game of Life
Four states,
```
1. 0 -> 0: nothing to worry about
2. 1 -> 0: we don't need to mark this state. After converting 2 and 3, we only need to turn them to 0 since they are dead
3. 0 -> 1: this state we need to focus, we mark as state 2, which needs 3 live neighbors
4. 1 -> 1: this state we need to focus, we mark as state 3, which needs 2 or 3 live neighbors
```
1. Define a helper function to count live neighbors for current index. Note we need to loop vertical, horizontal and diagnal directions, so loop would be [row - 1, row + 1], [col - 1, col + 1]. Once (new row, new col) is not(row, col) itself and satisfy with boarder situation, and also neighbor is 1 or 3, we need to update neighbor number.
2. Loop through matrix, for each index use method above to count neighbors. If current is 1, and neighbors are 2 or 3, mark it to 3. If current is 0 and neighbors are 3, mark as 2
3. Finally loop through matrix, turn 1 to 0, turn 3 to 1 and turn 2 to 1 
 
## 417. Pacific Atlantic Water Flow
Use 2 sets representing pacific and atlantic. Start from each ocean boundary and search for higher altitude inside and populate sets.
Finally cross check two sets' intersections.  

## 547. Number of Provinces
1. We use 1-D array to represent each city. Then start loop from first city and with DFS method to populate all the connected to current position and update final result
2. In DFS method, we loop through each city, if new position not visited and isConnected[i][j] == 1(means i and j connected), we mark j as visited and DFS recursively

## 695. Max Area of Island
For loop through array when we meet island and search with dfs.
In dfs, once we out of boundry or current position is 0, we return 0. Then mark current position 0 as visited and search 4 directions

## 733. Flood Fill
1. Get color of (sr, sc). If this color not equals to new color, do DFS method to populate result array
2. In DFS method, we first mark current position as new color. Then for 4 directions, once they satisfy boarder conditions and new position color is same, do DFS recursively


## 329. Longest Increasing Path in a Matrix
1. Create dp array represent each index with its longest increasing path. Loop through matrix, and use DFS method to update dp[r][c]. Note even if DFS method will return integer, we don't have to return a specific integer. We only want to populate dp array. Then loop again to update final result
2. In DFS method, the parameters we need to pass are row, col, boolean[][] visited to avoid repeat visit, int[][] dp, prev as -1. We first need to check if still in bounds and matrix[r][c] > prev. If not return 0. Also if new position has been visited, return dp[r][c]. Next we use path which initiated as 1 to update 4 directions max path. After updating path, mark (r, c) as visited and dp[r][c] as path

## 463. Island Perimeter
Loop through matrix, if matrix[r][c] == 1, result +4. If previous row or columns is also 1, then two of them connected would have a overlapped edge, so -2 if these situations
  
## 994. Rotting Oranges
Count total fresh oranges and use minutes to update final result.
Use deque to input row and col of rotten orange.
While loop deque until its empty or still have fresh. Add new direction which could be rotten to deque

## 1091. Shortest Path in Binary Matrix
1. We use BFS to solve this problem and we mark visited 0 as 1 to avoid extra space
2. We use LinkedList to store[row, col, path]. In BFS, we poll out arr and once row and col reaches end of matrix, we return path
3. Then search 8 directionally, once satisfy boundary criterias and [new row, new col] is 1 rather 0, we offer them to queue and mark as 1

## 1958. Check if Move is Legal
We want to change (r, c) to one color such that this color be a end point of ONE good line(at least 3 cell and two end points colors are same). So take (rMove, cMove) fixed, and search 8 directionally with dfs search and once there exists a good line simply return true. In dfs search, we need to calculate line length. While new row and col in boundaries and update row and col. When grid[new row][new col] is same color with stable point, we check if length greater than 3
