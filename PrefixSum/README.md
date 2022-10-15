## 1031. Maximum Sum of Two Non-Overlapping Subarrays
1. Create prefix sum array which length is array.length + 1. Prefix sum array will like [0,1,3,6,10,15] when original array is [1,2,3,4,5] which means we can simply represent any fixed length sum as prefixSum[i - fixed length]
2. With prefixSum array, we can start two way search, from firstLen to search, end at length - secondLen, then update maxFirst as prefixSum[i] - prefixSum[i - firstLen]. After got maxFirst, update result as maxFirst + prefixSum[i + secondLen] - prefixSum[i]. Same with secondLen

## 2017. Grid Game
![image](https://user-images.githubusercontent.com/43394670/196003417-a5c43d63-fa8e-4253-a64d-43c1099d3d6a.png)

