# Minimum Changes to Uniform

You are given an array of $n$ (we guarantee $n > 0$) integers $A=[a_1,…,a_n]$. What is the minimum number of elements of the array whose value you need to change such that all elements in the array have the same value?

For example, for $n=7$ and the array $A=[1, 3, 5, 1, 1, 3, 7]$, the minimum number of changes is $4$, and is obtained by changing all elements of the array equal to $1$. This requires changing the value of the elements $3$, $5$, $3$, and $7$.

You need to implement your solution as a method **minimumDistance($n$, $A$)** in the file Main.java.

**Grading** (100 points):
1. $40$ points for a solution that runs in time $$O(n^2)$$
2. $100$ points for a solution that runs in time $$O(n \log n)$$
3. Tests worth $20$ points are border case tests. 

**Note**: Border case tests are only included in the hidden tests, not in the public tests. The maximum number of points that you can get on the public tests is therefore $80$.

**Attention**: You are **NOT** allowed to use additional imports, other than the imports already included in the code template.
