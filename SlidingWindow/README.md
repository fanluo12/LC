## 3. Longest Substring Without Repeating Characters
### Given a string s, find the length of the longest substring without repeating characters.
Identify left pointer and for loop right pointer of string to update window. Use hash set to store unduplicate characters. Once hash set contains right character means already has duplicate and left pointer position must be the duplicated, so under this case remove left position character from set and update left pointer.

## 424. Longest Repeating Character Replacement
### Change character at k most times to format longest substring contains same letter 
Identify left pointer and for loop right pointer through string. Use map to store occurance of right pointer character and update max occurance of character. If window size > max + k, means we can replace in this window and in the meantime update left and remove left pointer character
