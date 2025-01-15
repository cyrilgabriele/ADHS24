import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// ADDITIONAL IMPORTS ARE NOT ALLOWED

class Main {
  public static void main(String[] args) {
    // Uncomment the following two lines if you want to read from a file
    // In.open("public/5-min_mst_small.in");
    // Out.compareTo("public/5-min_mst_small.out");
    // In.open("public/4-longest_cycle_large.in");
    // Out.compareTo("public/4-longest_cycle_large.out");
    In.open("public/example.in");
    Out.compareTo("public/example.out");

    int t = In.readInt(); // number of tests
    for (int test = 0; test < t; test++) {
      int n = In.readInt(); // number of vertices
      int query = In.readInt(); // method to test
      
      int[] U = new int[n];
      int[] V = new int[n];
      int[] C = new int[n];
      int[] D = new int[n];
      
      for (int i = 0; i < n - 1; i++) { // read edges
        U[i] = In.readInt(); // edge between parent U[i]
        V[i] = In.readInt(); // and child V[i]
        C[i] = In.readInt(); // of cost C[i]
      }
      for (int i = 1; i < n; i++) { // read D[1], ..., D[n - 1]
        D[i] = In.readInt();
      }
      
      if (query == 1) {
        Out.println(leaves(n, U, V, C, D));  
      } else if (query == 2) {
        Out.println(maxChildren(n, U, V, C, D));
      } else if (query == 3) {
        Out.println(longestCycle(n, U, V, C, D));
      } else {
        Out.println(minMST(n, U, V, C, D));
      }
    }
    
    // Uncomment this line if you want to read from a file
    In.close();
  }
  
  public static int leaves(int n, int[] U, int[] V, int[] C, int[] D) {
    boolean[] hasChild = new boolean [n];
    int counter = 0;
    
    for(int i=0; i<n; i++) {
      hasChild[U[i]] = true;
    }
    
    for(int j=0; j<n; j++) {
      if(!hasChild[j]) {
        counter++;
      }  
    }
    
    return counter;
  }
  
  public static int maxChildren(int n, int[] U, int[] V, int[] C, int[] D) {
    int[] numOfChildren = new int[n];
    int max = 0;
    
    for(int i=0; i<n; i++) {
      numOfChildren[U[i]]++;
    }
    
    for(int k=0; k<n; k++) {
      if(numOfChildren[k] > max) {
        max = numOfChildren[k];
      }
    }
    
    return max;
  }
  
  public static int longestCycle(int n, int[] U, int[] V, int[] C, int[] D) {
    // For your convenience, we consutrct G and H such that:
    // G.get(i).get(j) = the j-th child of vertex i
    // H.get(i).get(j) = cost of the edge between vertex i and the j-th child of vertex i
    // The number of elements of G.get(i) is given by G.get(i).size().
    ArrayList<ArrayList<Integer>> G = new ArrayList<ArrayList<Integer>>(n);
    ArrayList<ArrayList<Integer>> H = new ArrayList<ArrayList<Integer>>(n);
    for (int i = 0; i < n; i++) { // initialization with empty arrays
      G.add(new ArrayList<Integer>());
      H.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < n - 1; i++) { // adding information from (U, V, C) to (G, H)
      G.get(U[i]).add(V[i]);
      H.get(U[i]).add(C[i]);
    }
    
    // from here my code!
    int[] pathcosts = new int[n];
    int maxCycle = 0; 
    Arrays.fill(pathcosts, 0);
    
    //apply DFS to compute the path costs
    dfs(n, G, H, 0, pathcosts);
    
    for(int i=1; i<n; i++) {
      int cycleLenth = pathcosts[i] + D[i]; 
      maxCycle = Math.max(maxCycle, cycleLenth);
    }
    
    return maxCycle;
  }
  
  public static void dfs(int n, ArrayList<ArrayList<Integer>> G, 
    ArrayList<ArrayList<Integer>> H, int indexStartingVertex, int[] pathCosts) {
    int[] T = {1}; // made as an array s.t. I can exploit the pass by reference of objects in Java 
    int[] pre = new int[n]; // pre-numbers
    int[] post = new int[n]; // post-number 
    Arrays.fill(pre, -1);
    Arrays.fill(post, -1);
    boolean[] visited = new boolean[n]; // here we mark the visited vertices 
    
    visit(G, H, indexStartingVertex, visited, pre, post, T, pathCosts, 0);
  }
  
  public static void visit(ArrayList<ArrayList<Integer>> G, 
    ArrayList<ArrayList<Integer>> H, int indexCurrentNode, boolean[] visited, 
      int[] pre, int[] post, int[] T, int[] pathCosts, int currentCost) {
        
    pre[indexCurrentNode] = T[0];
    T[0]++;
    visited[indexCurrentNode] = true;
    pathCosts[indexCurrentNode] = currentCost;
    
    for(int i=0; i<G.get(indexCurrentNode).size(); i++) {
      int indexChild = G.get(indexCurrentNode).get(i);
      int edgeCost = H.get(indexCurrentNode).get(i);
      if(!visited[indexChild]) {
        visit(G, H, indexChild, visited, pre, post, T, pathCosts, currentCost + edgeCost);
      }
    }
    post[indexCurrentNode] = T[0]; 
    T[0]++;
  }
  
  public static int minMST(int n, int[] U, int[] V, int[] C, int[] D) {
    // For your convenience, we consutrct G and H such that:
    // G.get(i).get(j) = the j-th child of vertex i
    // H.get(i).get(j) = cost of the edge between vertex i and the j-th child of vertex i
    // The number of elements of G.get(i) is given by G.get(i).size().
    ArrayList<ArrayList<Integer>> G = new ArrayList<ArrayList<Integer>>(n);
    ArrayList<ArrayList<Integer>> H = new ArrayList<ArrayList<Integer>>(n);
    for (int i = 0; i < n; i++) { // initialization with empty arrays
      G.add(new ArrayList<Integer>());
      H.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < n - 1; i++) { // adding information from (U, V, C) to (G, H)
      G.get(U[i]).add(V[i]);
      H.get(U[i]).add(C[i]);
    }
    
    // below here my code!
    
    ArrayList<ArrayList<int[]>> mst = buildMST(n, U, V, C);
    int[] parent = new int[n];
    int[] pathCosts = new int[n];
    int rootIndex = 0; 
    
    bfs(mst, rootIndex, parent, pathCosts);
    
    // Step 2: Process each potential new edge
    int currentMSTCost = Arrays.stream(C).sum();
    int minMSTCost = currentMSTCost;

    for (int v = 1; v < n; v++) { // Consider edges (0, v) with costs D[v]
        int newEdgeCost = D[v];
        int maxEdgeCostInCycle = determineSubstitution(mst, parent, pathCosts, 0, v, newEdgeCost);
        int newMSTCost = (currentMSTCost - maxEdgeCostInCycle) + newEdgeCost;
        minMSTCost = Math.min(minMSTCost, newMSTCost);
    }

    return minMSTCost;
  }
  
  public static ArrayList<ArrayList<int[]>> buildMST(int n, int[] U, int[] V, int[] C) {
    ArrayList<ArrayList<int[]>> mst = new ArrayList<ArrayList<int[]>>();
    
    for(int i=0; i<n; i++) {
      mst.add(new ArrayList<>());
    }
    
    for(int i=0; i<n; i++) {
      mst.get(U[i]).add(new int[]{V[i], C[i]});
      mst.get(V[i]).add(new int[]{U[i], C[i]});
    }
    
    return mst;
  }
  
  public static void bfs(ArrayList<ArrayList<int[]>> mst, int root, int[] parent, int[] pathCosts) {
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[mst.size()]; // seems dubious
    visited[root] = true; // mark root as visited
    queue.add(root);
    pathCosts[root] = 0;
    
    while(!queue.isEmpty()) {
      int currentVertex = queue.poll();
      for(int[] neighbors : mst.get(currentVertex)) {
        for(int i=0; i<mst.get(currentVertex).size(); i++) {
          int successor = neighbors[0]; 
          int edgeCosts = neighbors[1];
          if(!visited[successor]) { // VERY IMPORTANT => otherwise endless-loop possible 
            visited[successor] = true; 
            parent[successor] = currentVertex;
            pathCosts[successor] = pathCosts[currentVertex] + edgeCosts;
            queue.add(successor);
          }
        }
      }
    }
  }
  
  public static int determineSubstitution(
    ArrayList<ArrayList<int[]>> mst, int[] parent, int[] pathCosts, int r, int v, int newEdgeCost) {
    
    // Step 1: Find the path from r to root and v to root
    int lca = findLCA(r, v, parent); // Implement LCA logic
    int maxEdgeCost = 0;

    // Step 2: Traverse r -> LCA and v -> LCA to find maximum edge cost
    int current = r;
    while (current != lca) {
        int edgeCost = pathCosts[current] - pathCosts[parent[current]];
        maxEdgeCost = Math.max(maxEdgeCost, edgeCost);
        current = parent[current];
    }

    current = v;
    while (current != lca) {
        int edgeCost = pathCosts[current] - pathCosts[parent[current]];
        maxEdgeCost = Math.max(maxEdgeCost, edgeCost);
        current = parent[current];
    }

    // Step 3: Include the new edge cost in the cycle
    maxEdgeCost = Math.max(maxEdgeCost, newEdgeCost);

    // Step 4: Determine substitution
    return maxEdgeCost;
  }
  
  public static int findLCA(int r, int v, int[] parent) {
    // Step 1: Calculate depths of r and v
    int depthR = calculateDepth(r, parent);
    int depthV = calculateDepth(v, parent);

    // Step 2: Bring both nodes to the same depth
    while (depthR > depthV) {
        r = parent[r];
        depthR--;
    }
    while (depthV > depthR) {
        v = parent[v];
        depthV--;
    }

    // Step 3: Move both nodes upward until they meet
    while (r != v) {
        r = parent[r];
        v = parent[v];
    }

    return r; // LCA found
  }

  private static int calculateDepth(int node, int[] parent) {
      int depth = 0;
      while (node != -1) { // Root node has parent -1
          node = parent[node];
          depth++;
      }
      return depth;
  }



  
  public static int sumAllCosts(int n, ArrayList<ArrayList<Integer>> G, ArrayList<ArrayList<Integer>> H) {
    int sumAllCosts = 0;
    
    for(int i=0; i<n-1; i++) {
      for(int j=0; j<H.get(i).size(); j++) {
        int currentEdgeCost = H.get(i).get(j);
        // System.out.println("i: " + i);
        // System.out.println("costs from: " + i + " to " + j + ": " + currentEdgeCosts);
        sumAllCosts += currentEdgeCost;
      }
    }
    return sumAllCosts;
  }
  
  public static int[] maxEdge(int n, ArrayList<ArrayList<Integer>> G, ArrayList<ArrayList<Integer>> H) {
    int maxEdgeValue = -1;
    int maxFromIndex = -1; 
    int maxToIndex = -1; 
    int[] maxValues = {maxFromIndex, maxToIndex, maxEdgeValue};
    
    for(int i=0; i<n-1; i++) {
      for(int j=0; j<H.get(i).size(); j++) {
        int currentEdgeCost = H.get(i).get(j);
        // System.out.println("i: " + i);
        // System.out.println("costs from: " + i + " to " + j + ": " + currentEdgeCosts);
        if(currentEdgeCost>maxEdgeValue) {
          maxEdgeValue = currentEdgeCost;
          maxValues[0] = i;
          maxValues[1] = j; 
          maxValues[2] = maxEdgeValue;
        } 
      }
    }
    return maxValues;
  }
}