# Changes to Close Subsequence

You are given an array of $n$ integers $A=[a_0, ..., a_{n-1}]$ and another array of $m$ integers $B=[b_0, ..., b_{m-1}]$ of $m$ integers, with $n \geq m$. We guarantee that $n \geq 1$ and $m \geq 1$. You are also given another integer $k \geq 0$.

You can choose some of the integers in $A$ and change them to any other integers that you want. Your task is to find the minimum number of integers in $A$ that you need to change such that $A$ contains a subsequence of $m$ integers $C=[a_{i_0}, ..., a_{i_{m-1}}]$ (with $0 \leq i_0 < i_1 < ... < i_{m-1} < n$, not necessarily consecutive) such that $|B[i]-C[i]| \leq k$ for all $i=0,...,m-1$. Intuitively, this means that $A$ contains a subsequence of $m$ integers that is "close" to $B$ (in the sense that the absolute value difference between any two corresponding elements is at most $k$).

For example, for $A=[1, 6, 3, 3, 2, -8]$, $B=[1, 7, 5, -9]$, and $k=1$, the answer is $1$, and can be obtained, for example, by changing $A$ to $[1, 6, 3, 5, 2, -8]$, which contains the subsequence $[1, 6, 5, -8]$, which satisfies $|1-1|,|7-6|,|5-5|,|(-8)-(-9)| \leq 1 = k$.

You need to implement the solution as a method minChanges($n$, $m$, $k$, $A$, $B$).

**Grading** (100 points):
- $40$ points for a solution that runs in at most $2$ seconds when $n, m \leq 20$.
- $100$ points for a solution that runs in time $O(nm)$.
- Tests worth $20$ points are border case tests.

**Note**: Border case tests are only included in the hidden tests, not in the public tests. The maximum number of points that you can get on the public tests is therefore $80$.

**Attention**: You are **NOT** allowed to use additional imports, other than the imports already included in the code template.