public class Knapsack {

    public static void main(String[] args) {
        int[] profit = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int limit = 50;

        int result = knapsack(limit, weight, profit);
        System.out.println("result: " + result);

    }

    public static int knapsack(int limit, int[] weight, int[] profit) {
        int n = weight.length;
        int[][] dp = new int[n+1][limit+1];

        // initialization
        for(int l=0;l<=n;l++){dp[0][l]=0;}; // no element available => no profit possible
        for(int k=0;k<=n;k++){dp[k][0]=0;}; // weight limit is 0 => no element possible => no profit possible
        
        // recursion
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=limit; j++) {
                if(weight[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weight[i-1]] + profit[i - 1]);
                }                
            }
        }
        printTable(dp);
        return dp[n][limit];
    }

    public static void printTable(int[][] dp) {
        for(int[] row : dp) {
            for(int entry : row) {
                System.out.print(entry + "\t");
            }
            System.out.println();
        }
        
    }
        
    
}
