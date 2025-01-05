public class SubsetSumWDuplicates {
    
    public static void main(String[] args) {
        int[] A = {-1, 3, 4, 2, 7};
        int n = A.length-1;
        int b = 22;
        int [] [] [] DP = new int[3][n+1][b+1];
       
        for(int t=0; t <= 2; t++) {
            for(int i=0; i<=n; i++) {
                for(int s=0; s<=b; s++) {
                    DP[t][i][s] = -1;
                }
            }
        }

        System.out.println("Output:  " + subsetSumWDuplicates(n, b, DP, A));


    }

    public static boolean subsetSumWDuplicates(int n, int b, int [][][] DP, int[] A) {
        for(int t=0; t<=2; t++) {
            for(int i=0; i<=n; i++) {
                for(int s=0; s<=b; s++) {
                    // BASE CASE 1:
                    if(t==0 && s>=1) {
                        DP[t][i][s] = 0;
                    }
                    // BASE CASE 2:
                    if(i==0 && s>=1) {
                        DP[t][0][s] = 0;
                    }
                    // BASE CASE 3:
                    if(s==0) {
                        DP[t][i][s] = 1;
                    }
                }
            }
        }

        // Recurrence: loops begin w/ 1 bc otherwise in base cases
        for(int t=2; t <= 2; t++) { // max value of t is given from exercise description
            for(int i=1; i<=n; i++) {
                for(int s=1; s<= b; s++) {
                    DP[t][i][s] = 0;
                    if(DP[t][i-1][s] == 1) {
                        DP[t][i][s] = 1;
                    }
                    boolean sIsSmaller = s < A[i];
                    if (!sIsSmaller) { // chech for out of bounds!
                        if(DP[t][i-1][s-A[i]] == 1) {
                            DP[t][i][s] = 1;
                        } 
                    }
                    if(s >= 2*A[i]){
                        if(DP[t][i-1][s-2*A[i]] == 1) DP[t][i][s] = 1;
                    }
                }
            }
        }
        return DP[2][n][b] == 1;
    }

    public static void printDPTable(int[][][] DP, int t) {
        System.out.println("DP Table for t = " + t + ":");
        for (int i = 0; i < DP[t].length; i++) {
            for (int j = 0; j < DP[t][i].length; j++) {
                System.out.print(DP[t][i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
}
