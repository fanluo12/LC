# 1 total - 09/11/2022

## 7. Reverse Integer
Use while loop if x != 0. Each time compute remainder of x % 10 and update temporary result as result(initialize as 0) multiply 10 then add remainder. Remember we need to avoid overflow with this judgement: if (newResult - remainder) / 10 != result then return 0

## 50. Pow(x, n)
First two end condition, if n == 0 then return 1 and for negative power we need to return 1/x * myPow(1/x, -n-1)
Then we need to divide n with 2 and put to recursive function. If n % 2 == 1 we take x out to multiply recurse function
