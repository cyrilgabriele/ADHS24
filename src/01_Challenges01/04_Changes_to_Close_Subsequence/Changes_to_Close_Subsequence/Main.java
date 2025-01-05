// ADDITIONAL IMPORTS ARE NOT ALLOWED

class Main {
  public static void main(String[] args) {
    // Uncomment the following two lines if you want to read from a file
    // In.open("public/0-example.in");
    // Out.compareTo("public/0-example.out");
    /* 
    int testNum = In.readInt(); // number of tests
    for (int test = 0; test < testNum; test++) {
      int n = In.readInt();
      int m = In.readInt();
      int k = In.readInt();

      int[] A = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = In.readInt(); // element of array
      }

      int[] B = new int[m];
      for (int i = 0; i < m; i++) {
        B[i] = In.readInt(); // element of array
      }

      Out.println(minChanges(n, m, k, A, B));
    }

    // Uncomment this line if you want to read from a file
    // In.close();
    */
    int [] A = {1,6,3,3,2,-8};
    int [] B = {1,7,5,-9};
    int k = 1;

    int output = minChanges(6, 4, k, A, B);
    System.out.println(output);

  }

  public static int minChanges(int n, int m, int k, int[] A, int[] B) {
    // Initialize DP table with a large value for comparisons (infinity-like value)
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        dp[i][j] = Integer.MAX_VALUE - 1; // Use a large number to represent "infinity"
      }
    }

    // Base case
    dp[0][0] = 0; // No elements, no changes required

    // Fill DP table
    for (int i = 1; i <= n; i++) {
      dp[i][0] = 0; // Any prefix of A can match an empty B with 0 changes
      for (int j = 1; j <= m; j++) {
        // Option 1: Skip the current element of A
        dp[i][j] = dp[i - 1][j];

        // Option 2: Use A[i-1] to match B[j-1] (1-indexed conversion)
        if (Math.abs(A[i - 1] - B[j - 1]) <= k) {
          // No change needed if within range
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
        } else {
          // Change is needed
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
        }
      }
    }

    // The answer is the minimum changes needed to match the entire B in A
    printMatrix(dp, n, m);
    System.out.println("solution extraction: " + dp[n][m]);
    return dp[n][m];
  }

  public static int needChange(int elementA, int elementB, int k) {
    return (Math.abs(elementA - elementB) <= k) ? 0 : 1;
  }
  
  public static int getMinElement(int [][] dpTable, int indexLastRow, int yMax) {
    int minValueLastRow = 2147483646;
    for (int i=0; i < yMax; ++i) {
      if(dpTable[indexLastRow][i] < minValueLastRow) {
        minValueLastRow = dpTable[indexLastRow][i];
      }
    }
    return minValueLastRow;
  } 

  public static void printMatrix(int [][] dpTable, int n, int m) {
    System.out.println("n: " + n);
    System.out.println("m: " + m);
    for (int i=0; i <= n; ++i) {
      for (int j=0; j <= m; ++j) {
        System.out.println(dpTable[i][j]);
      }
    }
  }
}