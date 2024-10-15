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
    
    

    for (int i = 0; i <= n; ++i) {

    }
    
    return 0;
  }

  public static int [] mergeSort(int [] A, int l, int r) {
    // here first sort the Array A
    if (l < r) {
      int m = l + r / 2; //check if this works 

      mergeSort(A, l, m);
      mergeSort(A, m+1, r);
      merge(A, l, m, r);
    }

    return A;
  }

  public static int [] merge(int [] A, int l, int m, int r) {
    int [] B = new int [r-l+1];
    int i = l;
    int j = m+1;
    int k = 1;

    while (i <= m && j <= r) {
      if (A[i] < A[j]) {
        B[k] = A[i];
        i++;
        k++;
      } else {
        B[k] = A[j];
        j++;
        k++;
      }
    } 
    return A;
  }
}