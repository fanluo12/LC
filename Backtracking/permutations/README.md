## 46. Permutations
1. Use visited array to mark visited indices
2. In backtrack method, we first judge temporary list, ie path, whether if its size reaches end. If so, add to result list
3. Loop through from 0 to end of array, once index has been visited, continue to break, then add to path and mark visited

## 47. Permutations II
Similar to 46, but need to remove duplicate
1. We need to sort array first
2. Same with backtrack above. The different part is in looping, we need to check if index has been visited or if it is greater than 0 and equals to previous index, and previous index not visited, we break single loop
