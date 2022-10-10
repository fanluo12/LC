# 10 total - 09/18/2022

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

## 127. Word Ladder
Use map to store pattern of each word with replacing each character to *. Key as pattern and value as word
Use deque to add word into it. While looping deque until it is empty, each time we poll word from deque. If word happends to be end word just return it. Else, we need find this word's all pattern and see if map contains it and use visited set to reduce duplicate times

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
We want to know grid2 islands are sub islands of grid1, first we traverse two grids, once grid1[r][c] is water and grid2[r][c] is land, we use dfs function to convert grid2[r][c] and neighbor islands as water, ie 0. After this we can simply traverse two grids and find union of them
