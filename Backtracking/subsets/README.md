## 78. Subsets
1. In backtrack method, since we need to add empty list to result, we first should add temporary list, ie path to result
2. Then loop through from start variable, each time add nums[i] to path and start backtrack from i + 1 position

## 90. Subsets II
Similar to above, but need to exclude duplicate
1. Every time when we meet duplicate, we need to sort array first
2. Backtrack method same with above except looping. When looping, we need to judge if i > start and nums[i[ == nums[i - 1], if so we continue to break this loop
