# 4 total - 09/11/2022

## 6. Zigzag Conversion
Use String array to store. Each row initiate as empty string
For loop through string to put characters to string array. For each character input, string arr[row] += character and update row += direction(initialize as 0). We need to update directions to 1 if row == 0 and -1 if row == numRows - 1

## 8. String to Integer (atoi)
1. First judge if s == null("") or s.length()==0 and simply return 0 for these corner case
2. Trim string to remove empty space
3. Use LONG type to update sum
4. Define index and sign. If trimmed string first index is -1(1), then update index(+1 for all case) and sign -1(for first indexi s -1)
5. For loop through from index to s.length()-1. In for loop, first we need to judge if it is digit or not. If not, we need to return sum*sign with int type right away
6. Then update sum = sum * 10 + s.charAt(i) - '0' since we cannot use String.valueOf
7. In the meantime we need to see if result sum is greater of less then Integer.MAX(MIN)_VALUE

## 38. Count and Say
Use a function to update stirng s. In this function, we use string builder to update. If index from 1 to i are same to 0 index, then count ++, else add current count and character to stringbuilder

## 65. Valid Number
Use digit, e, decimal, sign these boolean variables to judge. Straight forward to see under what circumstance would return false

## 205. Isomorphic Strings
Create two 265-bit ascll character arrays. Loop through string length and put each ascll value(eg 'a' would be 97) as index to each array and value as for loop pointer plus 1. Once m1[s[i]] != m2[t[j]] return false

## 214. Shortest Palindrome
This one is HARD. Simple brute-force method:
Example: s = dedcba. Then t = abcded
s          dedcba
  r[0:]      abcded    Nope...
  r[1:]   (a)bcded     Nope...
  r[2:]  (ab)cded      Nope...
  r[3:] (abc)ded       Yes! Return abc + dedcba
  
 ## 299. Bulls and Cows
 Use a number array which from 0-9 to represent each number.
 For loop through string, if secret[i] == guess[i], update bulls result. Else, use current digit of secret to +1 in numbers array and guess -1 in array. Once nums[secret[i]] < 0 or nums[guess[i] > 0], update cows

## 412. Fizz Buzz
Convert int to string
1. Integer.toString(int)
2. String.valueOf(int)

## 1221. Split a String in Balanced Strings && 1963. Minimum Number of Swaps to Make the String Balanced
### 1221
We only need to count L and R and update plus 1 to result when they are equal. If previous results are equal, even if upcoming combination equal, it would also work
### 1963. Minimum Number of Swaps to Make the String Balanced
If we meet ], we add 1 to close variable, else -1. Then we update max of close and return (max close + 1) / 2
