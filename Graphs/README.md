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
