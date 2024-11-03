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
    int [][] dpTable = new int [B.length] [A.length]; 
    
    for (int i=0; i <= B.length-1; ++i) {
      for (int j=0; j <= A.length-1; ++j) {
        // BASE CASE 1: (?)
        if(i == 0) {
          dpTable [i][j] = needChanges(A[j], B[i], k);
        }
        // BASE CASE 2: (?)
        if (i > j) {
          dpTable [i][j] = 2147483646; 
        }
        if (i!=0 && j!=0 && dpTable[i-1][j-1] != 2147483646) {
          dpTable[i][j] = needChanges(A[j], B[i], k) + dpTable[i-1][j-1];   
        }
      }
    }
    return getMinElement(dpTable, B.length-1, A.length-1);
  }

  public static int needChanges(int elementA, int elementB, int k) {
    return (Math.abs(elementA - elementB) <= 1) ? 0 : 1;
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
}