public class HS22_DP {
    
    public static void main(String[] args) {
        int[] A = {2, 2, 4, 6, 0, 12};
        int n = A.length;
        int maxA = 12; 

        int result = dpAlgo(A, n, maxA);
        System.out.println(result);
    }

    public static int dpAlgo(int[] A, int n, int maxA) {
        int[][] dp = new int[n][maxA+1];
        
        // INITIALIZATION 
        // BASE CASE 1
        for(int i=0; i<n; i++) {
            dp[i][0] = 1;
        }
        // BASE CASE 2
        for(int j=0; j<=maxA; j++) {
            dp[0][j] = (j==A[0]) ? 1 : 0; 
        }

        // RECURSION 
        for(int i=1; i<n; i++) {
            for(int j=0; j<=maxA; j++) {
                // CASE 1: do NOT take element, since it does not sum up to desired j
                        // in this case take the dp-entry without adding the current A[i]
                        // => look it up in dp[i-1][j]
                dp[i][j] = dp[i-1][j];

                // CASE 2: take element if adds up to desired value j
                if(j >= A[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-A[i]]);
                }
            }
        }
        printTable(dp);
        // SOLUTION EXTRACTION
        return solutionExtraction(A, dp, n);
    }

    private static int solutionExtraction(int[] A, int[][] dp, int n) {
        for (int i=1; i<n; i++) {
            if (A[i]>0 && dp[i-1][A[i]] == 0) {
                return 0; 
            }
        }
        return 1; 
    }

    private static void printTable(int[][] dp) {
        for(int[] row : dp) {
            for(int entryInRow : row) {
                System.out.print(entryInRow+"\t");
            }
            System.out.println();
        }
    }
    
}
