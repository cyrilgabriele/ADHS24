// ADDITIONAL IMPORTS ARE NOT ALLOWED

class Main {
  public static void main(String[] args) {
    // Uncomment the following two lines if you want to read from a file
    // In.open("public/example.in");
    // Out.compareTo("public/example.out");

    int testNum = In.readInt(); // number of tests
    for (int test = 0; test < testNum; test++) {
      int m = In.readInt(); // Number of Edges.
      int n = In.readInt();
      int[][] A = new int[m][2]; // 2D Array consisting of edges in G.
      for (int i = 0; i < m; i++) {
        A[i][0] = In.readInt(); 
        A[i][1] = In.readInt();
      }
      Out.println(mostFrequent(m, n, A));
    }
  }
    // Uncomment this line if you want to read from a file
    // In.close();

  public static int mostFrequent(int m, int n, int[][] A) {
    
    return 0;
  }
}
