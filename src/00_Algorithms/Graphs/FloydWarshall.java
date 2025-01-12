import java.util.ArrayList;
import java.util.Arrays;

public class FloydWarshall {
    public static void main(String[] args) {   
        // Number of vertices in the graph
        int n = 4;

        // Edges represented as U (source), V (destination), and C (costs/weights)
        int[] U = {0, 0, 1, 1, 2, 3};
        int[] V = {1, 3, 0, 3, 1, 2};
        int[] C = {3, 5, 2, 4, 1, 2};

        // Step 1: Build adjacency lists
        ArrayList<ArrayList<Integer>> G = new ArrayList<>(n);
        ArrayList<ArrayList<Integer>> H = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            G.add(new ArrayList<>());
            H.add(new ArrayList<>());
        }
        for (int i = 0; i < U.length; i++) { // Populate adjacency lists
            G.get(U[i]).add(V[i]);
            H.get(U[i]).add(C[i]);
        }

        // Print adjacency lists for verification
        System.out.println("Graph (Adjacency List Representation):");
        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + i + " -> " + G.get(i) + " with weights " + H.get(i));
        }

        // Call your floydWarshall method
        int result = floydWarshall(n, G, H, C);
        System.out.println("result: " + result);
    }

    public static int floydWarshall(int n, ArrayList<ArrayList<Integer>> G, ArrayList<ArrayList<Integer>> H, int[] C) {
        int[][] dp = new int[n][n];

        // initialization
        // DOES NOT WORK FOR A 2D ARRAY!!
        // Arrays.fill(dp, Integer.MAX_VALUE/2);
        for(int x=0; x<n;x++) {
            for(int y=0; y<n;y++) {
                if(x == y) {
                    dp[x][y] = 0;
                } else {
                    dp[x][y] = getEdgeCosts(x, y, G, H) ;
                }
            }
        }

        // recursion
        for (int k=0; k<n; k++){
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(dp[i][k] != Integer.MAX_VALUE && dp[k][j] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    };
                }
            }
        } 

        return dp[0][3];
    }

    private static int getEdgeCosts(int i, int j, ArrayList<ArrayList<Integer>> G, ArrayList<ArrayList<Integer>> H) {
        // Iterate through neighbors of vertex i
        for (int index = 0; index < G.get(i).size(); index++) {
            if (G.get(i).get(index) == j) { // Check if neighbor is j
                return H.get(i).get(index); // Return the corresponding cost
            }
        }
        return Integer.MAX_VALUE; // If j is not a neighbor, return "infinity"
    }
}
