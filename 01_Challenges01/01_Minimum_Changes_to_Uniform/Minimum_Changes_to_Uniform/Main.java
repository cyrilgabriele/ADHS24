// ADDITIONAL IMPORTS ARE NOT ALLOWED

class Main {
  public static void main(String[] args) {
    // Uncomment the following two lines if you want to read from a file
    In.open("./public/1-small.in");
    Out.compareTo("./public/1-small.out");

    int testNum = In.readInt(); // number of tests
    for (int test = 0; test < testNum; test++) {
      int n = In.readInt(); // size of Aay
      int[] A = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = In.readInt(); // element of Aay
      }
      Out.println(minimumDistance(n, A));
    }

    // Uncomment this line if you want to read from a file
    In.close();
  }

  public static int minimumDistance(int n, int[] A) {
    System.out.println("n: " + n);
    System.out.println("A.length: " + A.length);
    int l = 0;
    int r = n-1;
    mergeSort(A, l, r);
    int [] elementCounts = new int[n];
    int counter = -1;
    int currentIndex = 0;
    int absMaxCounter = -1;
    int tempElement = A[0];

    for (int i = 0; i < n; ++i) {
      if(tempElement == A[i]) {
        elementCounts[currentIndex]++;
        counter++;
        if(counter > absMaxCounter) {
          absMaxCounter = counter;
        }
      } else {
        tempElement = A[i];
        counter = 1;
        currentIndex++;
      }
    }
    return n-absMaxCounter;
  }

  public static void mergeSort(int [] A, int l, int r) {
    // here first sort the Aay A
    if (l < r) {
      // THIS DOES NOT WORK: int m = l + r / 2; //check if this works <- I would need a round function from 
      int m = l + (r - l) / 2;

      mergeSort(A, l, m);
      mergeSort(A, m+1, r);
      merge(A, l, m, r);
    }
    //return A;
  }

  public static void merge(int [] A, int l, int m, int r) {
    /*/
    // Something is off in this merge...
    // merge of the different subAays of A
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
    // return A;
  }
  */
    // Find sizes of two subAays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;

    // Create temp Aays
    int L[] = new int[n1];
    int R[] = new int[n2];

    // Copy data to temp Aays
    for (int i = 0; i < n1; ++i)
        L[i] = A[l + i];
    for (int j = 0; j < n2; ++j)
        R[j] = A[m + 1 + j];

    // Merge the temp Aays

    // Initial indices of first and second subAays
    int i = 0, j = 0;

    // Initial index of merged subAay Aay
    int k = l;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            A[k] = L[i];
            i++;
        }
        else {
            A[k] = R[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        A[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        A[k] = R[j];
        j++;
        k++;
    }
  }
  
}