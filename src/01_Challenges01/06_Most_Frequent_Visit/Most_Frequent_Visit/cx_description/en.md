
# Most Frequent Visit

Given a connected graph $$G$$ consisting of $$n$$ nodes and $$m$$ edges, consider an Eulerian walk on $$G$$. Recall that an Eulerian walk is a walk which starts at some vertex $$v_1$$, and produces a sequence of vertices $$v_1 \to v_2 \to \dots \to v_t$$ such that each pair $$\{v_i, v_{i+1}\}$$ represents a unique edge from $$G$$ and such that by the time we reach $$v_t$$ we have seen all the edges in the graph *exactly* once. For a vertex $$v$$, the number of visits in the walk is the number of times $$v$$ appears in the sequence $$v_1, v_2, v_3, \dots, v_t$$.  

We want to find an Eulerian walk such that the number of visits to the most-visited vertex in the walk is maximized. 

Given as input the edges $$\{v_i, v_j\}$$ in $$G$$, find the **maximum** number of visits
 we can make to *any* vertex in the graph $$G$$ in an Eulerian walk of $$G$$. In case there is no Eulerian walk, return $$-1$$, and in case $$v_t$$ coincides with $$v_1$$, make sure to include the final visit to $$v_1$$ as well. 
 
 The input follows the following format:
 - For each test case, the first line specifies the number of edges ($m$) and the number of vertices ($n$).
 - This is then following by the $m$ lines specifying the edges in $G$. We use $0$-indexing for the vertices -- that is, the vertices are numbered from $0$ to $n-1$.

Some examples:

- Example 1: $$[0,1],[1,2]$$. The output is $$1$$ since we visit every vertex once.
- Example 2: $$[0,1], [1,3],[1,2]$$. The output is $$-1$$ since there is no Eulerian walk.
- Example 3: $$[0,1], [1,2], [2,0]$$. The output is $$2$$ since on any Eulerian walk we visit each vertex twice.
- Example 4: $$[0,1],[1,2],[2,3],[3,4],[4,2],[2,0]$$. The output is 3, since we visit node 2 thrice in the longest Eulerian walk starting at 2. See also the image below.

![](/cx_description/image.png)

**Grading**
- For $40$ points, your solution should run in time $$O\left(m \cdot n\right)$$. 
- For $100$ points your solution should run in time $$O\left(m + n\right)$$.
- Tests worth $20$ points are border cases.

**Note**: Border case tests are only included in the hidden tests, not in the public tests. The maximum number of points that you can get on the public tests is therefore 80.

**Attention**: You are **NOT** allowed to use additional imports (explicitly or implicitly), other than the imports already included in the code template. The only exceptions are the java.lang classes and functions included in cx_description/java_lang_whitelist.md.