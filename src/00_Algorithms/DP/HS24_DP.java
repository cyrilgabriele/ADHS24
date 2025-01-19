public class HS24_DP {
    public static void main(String[] args) {
        int[] A1 = {1, 1, 2, 4, 5, 3, 9}; 
        int n1 = A1.length;
        int[] A2 = {5, 2, 1, 3, 4, 10, 7};
        int n2 = A2.length;
        int[] A3 = {1, 2, 1, 4, 1, 1, 10};
        int n3 = A3.length;

        int resultA1 = dpAlgo(n1, A1);
        System.out.println("resultA1: " + resultA1);
        int resultA2 = dpAlgo(n2, A2);
        System.out.println("resultA2: " + resultA2);
        int resultA3 = dpAlgo(n3, A3);
        System.out.println("resultA3: " + resultA3);        
    }

    public static int dpAlgo(int n, int[] A) {
        int maxLen = 2;
        int[][] dp = new int[n][n]; 

        // BASE CASEs
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                dp[i][j] = 2; 
            }
        }

        // RECURSION
        for (int j=2; j<n; j++) {
            for (int i=1; i<j; i++) {
                for (int k=0; k<i; k++) {
                    if (A[k] + A[i] == A[j]) {
                        dp[i][j] = Math.max(dp[i][j], dp[k][i] + 1); 
                    }
                }
                maxLen = Math.max(maxLen, dp[i][j]); 
            }
        }

        return maxLen; 
    }


    public static void printTable(int[][] dp) {
        for(int[] row : dp) {
            for(int entry : row) {
                System.out.print(entry + "\t");
            }
        }
        System.out.println();
    }
}
