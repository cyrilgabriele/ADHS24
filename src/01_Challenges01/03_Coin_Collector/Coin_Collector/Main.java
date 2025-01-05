// ADDITIONAL IMPORTS ARE NOT ALLOWED

class Main {
  public static void main(String[] args) {
    // Uncomment the following two lines if you want to read from a file
    // In.open("public/1-small.in");
    // Out.compareTo("public/1-small.out");
    /* 
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
    */

    int [] A = {3, 1, 4, 2, 5, 3};
    // int [] A = {3, 1, 4, 2, 10};
    int T = 8; 
    int n = A.length;
    int result = coinCollect(n, A, T);
    System.out.println(result);
    // Uncomment this line if you want to read from a file
    // In.close();
  }
  
  /*
   if(T == A.length) {
      int maxElement = -1; 
      for (int i=0; i <= A.length-1; ++i) {
        if (maxElement < A[i]) {
         maxElement = A[i];
      }
    }
      return maxElement;
    }

    int sum = 0;
    for(int j=0; j <= A.length-1; ++j) {
      sum += A[j];
    }
    //System.out.println(sum);
    long fraction = (long) sum/T;
    //System.out.println(fraction);
    int X = (int) Math.ceil(fraction); 

    return X;
   */


  public static int coinCollect(int n, int[] A, int T) {
    int maxElement = -1; 
    for (int i=0; i <= A.length-1; ++i) {
      if (maxElement < A[i]) {
        maxElement = A[i];
      }
    }
    // early exit for case where: T=n 
    if(T == n) {
      return maxElement;
    }
    int leftPointer = 1; 
    int rightPointer = maxElement; 
    int X = maxElement;

    while(leftPointer <= rightPointer) {
      int pivot = leftPointer + (rightPointer - leftPointer) / 2;      
      int currentTotalSteps = currentTotalSteps(pivot, A);

      if(currentTotalSteps <= T) {
        X = pivot; 
        rightPointer = --pivot;
      } else {
        leftPointer = ++pivot;
      }
    }
    return X;
  }

  public static int currentTotalSteps(int currentX, int[] A) {
    int totalSteps = 0;
    for(int coin : A) {
      totalSteps += Math.ceil((double) coin / currentX);
    }
    return totalSteps;
  }
}