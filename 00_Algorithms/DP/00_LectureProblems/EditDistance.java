public class EditDistance {

    public static void main(String[] args) {
        char[] A = {'T','I', 'G', 'E', 'R'};
        char[] B = {'Z','I', 'E', 'G', 'E'};
        int n = A.length;
        System.out.println("n: " + n);
        int m = B.length;

        int result = editDistance(n, m, A, B);
        System.out.println("result: " + result);
        
    }
    
    public static int editDistance(int n, int m, char[] A, char[] B) {
        // solved w/ script but according to SMIROST "guidline"
        // S -ize of the table: [n+1][m+1] | +1 because of BASE CASEs
        int[][] dp = new int[n+1][m+1];
        // M -eaning: min edit distance for A[0...i] and B[0...i]
        // I -initialization
        // BASE CASES
        for(int i=0; i<=n; ++i) {dp[i][0] = i;};
        for(int j=0; j<=n; ++j) {dp[0][j] = j;};
        // R -ecursion
        // if a = b => dp[i][j] = dp[i-1][j-1]
        // else
        // dp[i][j] = 1 + Math.min(dp[i][j-1] //einfügen, dp[i-1][j] //löschen, dp[i-1][j-1] // ersetzen)
        // O -rder => top-down approach aka tabulation
        for(int s=1; s<=n; s++){
            for(int t=1; t<=m; t++) {
                if(A[s-1] == B[t-1]) {
                    dp[s][t] = dp[s-1][t-1]; 
                } else {
                    dp[s][t] = Math.min(dp[s][t-1]+1, Math.min(dp[s-1][t]+1, dp[s-1][t-1]+1));
                }
            }
        } 
        printTable(dp);
        // S -olution
        return dp[n][m];
        // T -ime
        // O(n*m) => this because for each table entry the time complexity is O(1)
    }

    public static void printTable(int[][] dp) {
        for(int[] row : dp) {
            for(int rowEntry : row) {
                System.out.println(rowEntry);
            }
            System.out.println("");
        }
    }
}
