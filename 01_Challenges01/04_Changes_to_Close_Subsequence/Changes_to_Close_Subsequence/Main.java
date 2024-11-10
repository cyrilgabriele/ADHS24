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
    int [] A = {3,6,3,3,2,-8};
    int [] B = {1,7,5,-9};
    int k = 1;

    int output = minChanges(1, 1, k, A, B);
    System.out.println(output);

  }

  public static int minChanges(int n, int m, int k, int[] A, int[] B) {
    int [][] dpTable = new int [B.length] [A.length]; 
    
    int minValuePreviousRow = 2147483645;
    for (int i=0; i <= B.length-1; ++i) { 
      for (int j=0; j <= A.length-1; ++j) {
        // BASE CASE 1: (?)
        if(i == 0) {
          dpTable [i][j] = needChange(A[j], B[i], k);
        }
        // BASE CASE 2: (?)
        if (i > j) {
          dpTable [i][j] = 2147483646; 
        }
        if (i!=0 && j!=0 && dpTable[i-1][j-1] != 2147483646) {
          //dpTable[i][j] = needChange(A[j], B[i], k) + dpTable[i-1][j-1];
          dpTable[i][j] = needChange(A[j], B[i], k) + minValuePreviousRow;   
        }
        if(dpTable[i][j] < minValuePreviousRow) {
          minValuePreviousRow = dpTable[i][j];
          System.out.println("minValue: " +minValuePreviousRow);
        }
      }
      minValuePreviousRow = 0;
    }
    printMatrix(dpTable, A, B);
    return getMinElement(dpTable, B.length-1, A.length-1);
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

  public static void printMatrix(int [][] dpTable, int [] A, int [] B) {
    for (int i=0; i <= B.length-1; ++i) {
      for (int j=0; j <= A.length-1; ++j) {
        System.out.println(dpTable[i][j]);
      }
    }
  }
}