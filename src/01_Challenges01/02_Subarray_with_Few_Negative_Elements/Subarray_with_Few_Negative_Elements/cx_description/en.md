# Subarray with Few Negative Elements

You are given an array of $n$ (we guarantee $n \geq 1$) integers $A=[a_1, ..., a_n]$. Your task is to find the length of the largest subarray (consecutive elements in the original array) that contains at most $2$ negative numbers (a number $a_i$ is "negative" if $a_i < 0$).

For example, for $n=10$ and the array $A=[-3, -4, 8, 4, -1, 6, 4, -2, -5, 2]$, the largest length is $6$, obtained for example for the subarray $[-4, 8, 4, -1, 6, 4]$.

You need to implement your solution as a method **longestSubarray($n$, $A$)** in the file Main.java.

**Grading** (100 points):
1. $40$ points for a solution that runs in time $$O(n^2)$$
2. $100$ points for a solution that runs in time $$O(n)$$
3. Tests worth $20$ points are border case tests. 

**Note**: Border case tests are only included in the hidden tests, not in the public tests. The maximum number of points that you can get on the public tests is therefore $80$.

**Attention**: You are **NOT** allowed to use additional imports, other than the imports already included in the code template.
