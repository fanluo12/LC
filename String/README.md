## 8. String to Integer (atoi)
1. First judge if s == null("") or s.length()==0 and simply return 0 for these corner case
2. Trim string to remove empty space
3. Use LONG type to update sum
4. Define index and sign. If trimmed string first index is -1(1), then update index(+1 for all case) and sign -1(for first indexi s -1)
5. For loop through from index to s.length()-1. In for loop, first we need to judge if it is digit or not. If not, we need to return sum*sign with int type right away
6. Then update sum = sum * 10 + s.charAt(i) - '0' since we cannot use String.valueOf
7. In the meantime we need to see if result sum is greater of less then Integer.MAX(MIN)_VALUE
