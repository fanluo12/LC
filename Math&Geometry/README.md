# 8 total - 09/18/2022

## 7. Reverse Integer
Use while loop if x != 0. Each time compute remainder of x % 10 and update temporary result as result(initialize as 0) multiply 10 then add remainder. Remember we need to avoid overflow with this judgement: if (newResult - remainder) / 10 != result then return 0

## 50. Pow(x, n) && 326. Power of Three
### 50
First two end condition, if n == 0 then return 1 and for negative power we need to return 1/x * myPow(1/x, -n-1)
Then we need to divide n with 2 and put to recursive function. If n % 2 == 1 we take x out to multiply recurse function
### 326
If n < 0 -> false; if n == 1 -> true; if n % 3 != 0 -> false; return function(n/3)

## 204. Count Primes
Create boolean array to update non-prime number.
For loop through from 2, if boolean[i] is false, update final result and loop through current index from 2 to see if i * j < n and update i * j place as true

## 523. Continuous Subarray Sum
1. For example, [23,2,4,...] and k = 6. 23 % 6 = 5, while after adding 2 and 4, 23 become 29 and 29 % 6 is also 5. So if remainder happens twice, means we already find a multiple of k. So we use hash map to store remainder of updating sum and index. Why index? Because our continuous array should be greater than 2, so if new index minus map.get(remainder) greater than 1, we can return true.
2. Note hash map need to be initialize as key = 0 and value = -1, so in this case when we updating sum, if sum % k == 0, we don't need to judge if map contains key or not

## 1260. Shift 2D Grid
