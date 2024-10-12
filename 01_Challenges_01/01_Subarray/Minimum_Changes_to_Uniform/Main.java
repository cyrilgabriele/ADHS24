// ADDITIONAL IMPORTS ARE NOT ALLOWED

class Main {
  public static void main(String[] args) {
    // Uncomment the following two lines if you want to read from a file
    In.open("./public/1-small.in");
    Out.compareTo("./public/1-small.out");

    int testNum = In.readInt(); // number of tests
    for (int test = 0; test < testNum; test++) {
      int n = In.readInt(); // size of array
      int[] A = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = In.readInt(); // element of array
      }
      Out.println(minimumDistance(n, A));
    }

    // Uncomment this line if you want to read from a file
    In.close();
  }

  public static int minimumDistance(int n, int[] A) {
    // TODO
    System.out.println(n);
    System.out.println(A);
    

    for (int i = 0; i <= n; ++i) {

    }
    
    return 0;
  }
}