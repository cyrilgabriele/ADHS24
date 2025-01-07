import java.util.*;

public class HS19_DP {
    public static void main(String[] args) { // Number of vertices in the graph (1-based indexing)
        int n = 5;

        // Graph as an adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph
        // Example graph:
        // 1 -> (2, 1), (3, 2)
        // 2 -> (4, 1)
        // 3 -> (4, 1)
        graph.get(1).add(new int[]{2, 1}); // Edge 1 -> 2 with weight 1
        graph.get(1).add(new int[]{3, 2}); // Edge 1 -> 3 with weight 2
        graph.get(2).add(new int[]{4, 1}); // Edge 2 -> 4 with weight 1
        graph.get(3).add(new int[]{4, 1}); // Edge 3 -> 4 with weight 1

        // Shortest distance array (already precomputed, for simplicity)
        // d[u] represents the shortest distance from source S to node u
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE / 2); // Initialize to "infinity"
        d[1] = 0; // Distance to source vertex is 0
        d[2] = 1;
        d[3] = 2;
        d[4] = 2;
        // d[5] remains Integer.MAX_VALUE/2 (unreachable)

        // Source (S) and Target (T) vertices
        int S = 1;
        int T = 4;

        // Pass everything to the dpAlgorithm method
        int result = dpAlgorithm(graph, n, d, S, T);
        System.out.println("result: " + result);
    }

    public static int dpAlgorithm(List<List<int[]>> graph, int n, int[] d, int S, int T) {
        // Create DP array to store the number of shortest paths to each vertex
        int[] dp = new int[n + 1];

        // BASE CASEs (Initialization)
        dp[S] = 1; // 1 way to reach the source
        for (int i = 1; i <= n; i++) {
            if (d[i] == Integer.MAX_VALUE / 2) {
                dp[i] = 0; // No paths to unreachable vertices
            }
        }

        // RECURSION: Process vertices in topological order
        for (int i = 1; i <= n; i++) {
            for (int[] edge : graph.get(i)) {
                int neighbor = edge[0];
                int weight = edge[1];
                // Check if this edge contributes to a shortest path
                if (d[i] + weight == d[neighbor]) {
                    dp[neighbor] += dp[i];
                }
            }
        }

        // Return the number of shortest paths to target vertex T
        return dp[T];
    }
}
