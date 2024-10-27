// ADDITIONAL IMPORTS ARE NOT ALLOWED

class Main {
  public static void main(String[] args) {
    // Uncomment the following two lines if you want to read from a file
    // In.open("public/0-example.in");
    // Out.compareTo("public/0-example.out");

    int testNum = In.readInt(); // number of tests
    for (int test = 0; test < testNum; test++) {
      int n = In.readInt();
      int T = In.readInt();
      int[] A = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = In.readInt(); // element of array
      }
      Out.println(coinCollect(n, A, T));
    }
    // Uncomment this line if you want to read from a file
    // In.close();
  }
    


  public static int coinCollect(int n, int[] A, int T) {
   // TODO:
   return 0;
  }
}