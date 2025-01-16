public class HS21_DP {
    public static void main(String[] args) {
        int[] array = {2, 3, 8, 1, 4, 5, 3};
        int n = array.length;
        int A = 8;
        int B = 30;

        int result = dpAlgo(n, A, B, array);
        System.out.println("result: " + result);
    }

    public static int dpAlgo(int n, int A, int B, int[] array) {
        int[][][] dp = new int[n+1][A+1][B+1];

        // BASE CASES
        for (int i=0; i <= n; i++) {  // Empty subset is always valid for sum = 0 and sum-of-squares = 0
            dp[i][0][0] = 1;
        }

        // RECURSION
        for (int i=1; i<=n; i++) {          
            for (int j=0; j<=A; j++) {      
                for (int k=0; k<=B; k++) {  
                    // Case 1: Exclude the current element
                    dp[i][j][k] = dp[i-1][j][k];
                    // Case 2: Include the current element, if valid
                    if (((j - array[i-1]) >= 0) && ((k - (array[i-1] * array[i-1])) >= 0)) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j - array[i-1]][k - (array[i-1] * array[i-1])]);
                    }
                }
            }
        }
        return dp[n][A][B]; 
    }
}
