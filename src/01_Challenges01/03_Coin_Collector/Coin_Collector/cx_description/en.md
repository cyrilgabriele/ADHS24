# Coin Collector

We are given an array $$A$$ of $$N$$ positive integers, where $$A[i]$$ represents the number of coins at position $$i$$.  We want to collect all the coins. Given as input an integer $$T$$, we want to collect the coins in at most $$T$$ steps. We are allowed to choose the number $$X$$ of coins that we can pick up in each step. The goal is to pick $$X$$ as small as possible.

More precisely, at each step, we pick a position $$i$$ and:
* If $$A[i] \leq X$$: we collect $$A[i]$$ coins, and the value of $$A[i]$$ changes to $$0$$.
* If $$A[i] > X $$, we collect $$X$$ coins, and the value of $$A[i]$$ changes to $$A[i] - X$$.

Note that the above is equivalent to saying we pick $$\min\{A[i], X\}$$ many coins at position $$i$$ in a single step.

Given as input $$A, T$$, find the **minimum** value of $$X$$ such that we can collect all the coins in the array.  You can assume that $$T \geq N$$ and that $$1 \leq A[i] \leq C$$.

- Example 1: $$[3,1,4,2,10], \ T=5$$. We can pick $$X=10$$ to solve the problem. 
- Example 2: $$[3,1,4,2,5,3], \ T=8$$. We can pick $$X=3$$ to solve the problem.

It might be useful to use the ```long``` datatype for this task.

**Grading**
- For 40 points, your solution should run in time $$O\left(N \cdot C\right)$$. 
- For 100 points your solution should run in time $$O\left(N \cdot \log C \right)$$.
- Tests worth 20 points are border cases.

**Note**: Border case tests are only included in the hidden tests, not in the public tests. The maximum number of points that you can get on the public tests is therefore 80.

**Attention**: You are **NOT** allowed to use additional imports, other than the imports already included in the code template.