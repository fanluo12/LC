## 3. Longest Substring Without Repeating Characters
### Given a string s, find the length of the longest substring without repeating characters.
Identify left pointer and for loop right pointer of string to update window. Use hash set to store unduplicate characters. Once hash set contains right character means already has duplicate and left pointer position must be the duplicated, so under this case remove left position character from set and update left pointer.
