# 1 total - 09/11/2022

## 7. Reverse Integer
Use while loop if x != 0. Each time compute remainder of x % 10 and update temporary result as result(initialize as 0) multiply 10 then add remainder. Remember we need to avoid overflow with this judgement: if (newResult - remainder) / 10 != result then return 0
