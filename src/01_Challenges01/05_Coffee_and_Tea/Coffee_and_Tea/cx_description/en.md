**Coffee and Tea**

You are preparing a party, and you have bought $k$ cups of coffee and $k$ cups of tea to serve the guests. Now it's time to invite your friends to the party. You have $n$ friends, numbered from $0$ to $n-1$, whom you could invite. However, friend number $i$ will want to drink $A[i]$ cups of coffee and $B[i]$ cups of tea at the party, and will not attend otherwise. What is the maximum number of friends that you can invite such that you have enough coffee and tea for all of them?

You are given as input the numbers $n$, $k$, and two arrays $A=[a_0, ..., a_{n-1}]$ and $B=[b_0, ..., b_{n-1}]$, each of $n$ integers. We guarantee $n \geq 1$, $k \geq 0$, and $a_i, b_i \geq 0$ for all $i=0,...,n-1$.

For example, for $n=5$, $k=6$, $A=[0, 1, 3, 2, 1]$, and $B = [5, 2, 2, 1, 2]$, the answer is $3$, by inviting the friends number $1$, $3$, and $4$ (then they consume $A[1] + A[3] + A[4] = 4$ cups of coffee and $B[1] + B[3] + B[4] = 5$ cups of tea). 

You need to implement the solution as a method maxFriends($n$, $m$, $k$, $A$, $B$).

**Grading**
- $20$ points for a solution that runs in at most $3$ seconds when $n, m \leq 20$.
- $80$ points for a solution that runs in time $O(\max(n,k)^3)$.
- $100$ points for a solution that runs in time $O(n^2k)$
- Tests worth $20$ points are border cases, which will require time complexity $O(\max(n,k)^3)$ or better.

**Note**: Border case tests are only included in the hidden tests, not in the public tests. The maximum number of points that you can get on the public tests is therefore $80$.

**Attention**: You are **NOT** allowed to use additional imports (explicitly or implicitly), other than the imports already included in the code template. The only exceptions are the java.lang classes and functions included in cx_description/java_lang_whitelist.md.