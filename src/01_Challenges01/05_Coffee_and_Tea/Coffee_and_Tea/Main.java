// ADDITIONAL IMPORTS ARE NOT ALLOWED

class Main {
  public static void main(String[] args) {
    /*
    // Uncomment the following two lines if you want to read from a file
    // In.open("public/example.in");
    // Out.compareTo("public/example.out");

    int testNum = In.readInt(); // number of tests
    for (int test = 0; test < testNum; test++) {
      int n = In.readInt();
      int k = In.readInt();

      int[] A = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = In.readInt(); // element of array
      }

      int[] B = new int[n];
      for (int i = 0; i < n; i++) {
        B[i] = In.readInt(); // element of array
      }

      Out.println(maxFriends(n, k, A, B));
    }

    // Uncomment this line if you want to read from a file
    // In.close();
    */

    int [] A = {0,1,3,2,1};
    int [] B = {5,2,2,1,2};
    int n = 5;
    int k = 6;

    int result = maxFriends(n, k, A, B);
    System.out.println("result: " + result);

  }
  
  /* 
  public static int maxFriends(int n, int k, int[] A, int[] B) {
    // Initialize a 3D DP array
    int[][][] dp = new int[n + 1][k + 1][k + 1];

    // Fill the DP table
    for (int i = 1; i <= n; i++) { // Iterate through friends
      for (int c = 0; c <= k; c++) { // Iterate through coffee limits
        for (int t = 0; t <= k; t++) { // Iterate through tea limits
          // Option 1: Do not invite the current friend
          dp[i][c][t] = dp[i - 1][c][t];

          // Option 2: Invite the current friend if requirements are within limits
          if (c >= A[i - 1] && t >= B[i - 1]) {
            dp[i][c][t] = Math.max(dp[i][c][t], 1 + dp[i - 1][c - A[i - 1]][t - B[i - 1]]);
          }
        }
      }
    }

    // The maximum number of friends we can invite with k cups of coffee and tea
    return dp[n][k][k];
  }
  */
  
  
  // THIS IS NOT WORKING... 
  public static int maxFriends(int n, int k, int[] A, int[] B) {
    int[][][] dp = new int[k][n][n];

    // dp table initialization
    for (int i=0; i<k; i++) { 
      for (int j=0; j<n; j++) { 
        for (int m=0; m<n; m++) {
          // BASE CASE
          if(i==0 && j==0 && m==0){
            dp[i][j][m] = 0;
          } else {
            dp[i][j][m] = Integer.MAX_VALUE / 2;
            //dp[i][j][m] = 0;
          }
        }
      }
    }
    
    // Main DP loop
    for (int coffee=0; coffee<k; coffee++) { // cups of coffee (coffee consumed)
      for (int x=1; x<n-1; x++) { // x-axis (friend we look at)
        for (int y=0; y<n; y++) { // y-axis (count tea)
          if(A[x] <= coffee && y>0) {
            System.out.println("I AM HERE");
            System.out.println("x= " + x);
            // Option 1: invite friend if coffee req. staisfied
            dp[coffee][x][y] = Math.min(dp[coffee][x][y], B[x] + dp[coffee-A[x]][x-1][y-1]);
            //coffee = coffee - A[x];
          } else {
            // Option 2: DO NOT invite friend w.r.t coffee req. extended 
            dp[coffee][x][y] = dp[coffee][x-1][y];
          }
        }
      }
    }

    for(int i=0; i<)
    return 0;
  }
  

  /*
  public static int maxFriends(int n, int k, int[] A, int[] B) {
    // Create a 2D DP table
    int[][] dp = new int[k + 1][n + 1];
  
    // Fill the DP table
    for (int i = 1; i <= k; i++) { // Iterate over available cups
      for (int j = 1; j <= n; j++) { // Iterate over friends
        // Option 1: Skip the current friend
        dp[i][j] = dp[i][j - 1];
  
        // Option 2: Invite the current friend if requirements are satisfied
        if (i >= A[j - 1] && i >= B[j - 1]) {
          dp[i][j] = Math.max(dp[i][j], 1 + dp[i - A[j - 1]][j - 1]);
        }
      }
    }
  
    // The answer is stored in dp[k][n]
    return dp[k][n];
  }
  */
  

  
  public static void printDPTable(int[][][] DP, int k, int n) {
    System.out.println("DP Table for k = " + k + ":");
    for (int j = 0; j < n; j++) {  // Loop over "j" (rows in DP[k])
        for (int m = 0; m < n; m++) {  // Loop over "m" (columns in DP[k])
            System.out.print(DP[k][j][m] + " "); // Print the value at [k][j][m]
        }
        System.out.println(); // New line after each row
    }
    System.out.println(); // Extra space between tables for readability
  }
}