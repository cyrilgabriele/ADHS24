// ADDITIONAL IMPORTS ARE NOT ALLOWED

class Main {
  public static void main(String[] args) {
    // Uncomment the following two lines if you want to read from a file
    // In.open("public/0-example.in");
    // Out.compareTo("public/0-example.out");

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
  }

  public static int minChanges(int n, int m, int k, int[] A, int[] B) {
    // TODO
    return 0;
  }
}