public class SubsetSum {
    public static void main(String[] args) {
        int[] A = {5, 3, 10, 7, 3, 1};
        int n = A.length;
        int s = 9;
        boolean isSpossible = subsetSum(n, A, s);
        // boolean isSpossible = naiveSubsetSum(n, A, s);
        System.out.println("subset sum is possible: " + isSpossible);
        
    }

    public static boolean subsetSum(int n, int[] A, int s) {
        // implemented w.r.t. the SMIROST guide line 
        int[][] dp = new int[n+1][s+1];
        // BASE CASEs
        for(int m=0; m<=s; m++) { dp[0][m] = 0;}; // if A empty => only s = 0 possible 
        for(int l=0; l<=n; l++) { dp[l][0] = 1;}; // if subset sum s = 0 => always possible

        // recursion
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=s; j++) {
                if(A[i-1] > j) {
                    // DO NOT take element A[i-1] since it is greater than s_j
                    dp[i][j] = dp[i-1][j]; // if it was possible to build the subset sum already w/ the previous elements then 1 else 0 
                } else {
                    if (A[i-1] > j) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] | dp[i - 1][j - A[i - 1]];
                    }
                    
                }
            }
        }
        printTable(dp);
        return dp[n][s] == 1;
        // runtime complexity: O(s*n) => pseudopolynomial
    }

    public static boolean naiveSubsetSum(int n, int[] A, int s) {
        // BASE CASEs
        // subset sum is 0 => reached the sum aka possible    
        if (s==0) {return true;};
        // no elements in Array A aka only subset sum possible is 0
        if (n==0 || s < 0) {return false;};

        // ignore current element if element > s 
        if (A[n - 1] > s) {return naiveSubsetSum(n - 1, A, s);};        

        // (naive) recursion: take element || do NOT take it 
        // => then call with n-1 and either the adjusted s or the unaltered s if A[n] not taken
        return naiveSubsetSum(n-1, A, s - A[n-1]) || naiveSubsetSum(n-1, A, s);
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
