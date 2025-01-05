// ADDITIONAL IMPORTS ARE NOT ALLOWED

class Main {
  public static void main(String[] args) {
    // Uncomment the following two lines if you want to read from a file
    /* 
    In.open("./public/1-small.in");
    Out.compareTo("public/example.out");

    int testNum = In.readInt(); // number of tests
    for (int test = 0; test < testNum; test++) {
      int n = In.readInt(); // size of array
      int[] A = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = In.readInt(); // element of array
      }
      Out.println(longestSubarray(n, A));
    }

    // Uncomment this line if you want to read from a file
    In.close();
    */

    int [] A = {-2, 3, -5, 5, 6, -8, -9};
    int distance = longestSubarray(A.length, A);
    System.out.println(distance);

  }

  public static int longestSubarray(int n, int[] A) {
    // TODO 
    int [] negativeIndices = getNegativeIndices(n, A);
    int [] longestDistanceInformation = getLongestDistanceIndices(n, negativeIndices);

    return longestDistanceInformation[0];
    
  }

  public static int [] getNegativeIndices(int n, int [] A) {
    int [] negativeIndices = new int[n]; 
    int currentIndex = 0;

    for(int i = 0; i < n; ++i) {
      if(A[i] < 0) {
        negativeIndices[currentIndex] = i; 
        currentIndex++;
      }
    }
    return negativeIndices;
  }

  public static int [] getLongestDistanceIndices(int n, int [] negativeIndices) {
    int maxDistance = -1; 
    int maxIndexLeft = -1; 
    int maxIndexRight = -1; 

    for (int j = 0; j < (n - 1); ++j){
      int distance = 1;
      System.out.println("negativeIndices[j+1] " + negativeIndices[j+1]);
      System.out.println("negativeIndices[j] " + negativeIndices[j]);
      distance = (negativeIndices[j+1] - negativeIndices[j]) + 1;  

      if (distance >= maxDistance) {
        maxDistance = distance;
        maxIndexLeft = negativeIndices[j]; 
        maxIndexRight = negativeIndices[j+1];
      }
      distance = 0;
    }
    System.out.println("maxDistance " + maxDistance);
    int [] returnArray = {maxDistance, maxIndexLeft, maxIndexRight};
    return returnArray;
  }
}