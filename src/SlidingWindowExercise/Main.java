// ADDITIONAL IMPORTS ARE NOT ALLOWED

class Main {
  public static void main(String[] args) {
    // Uncomment this line if you want to read from a file
    In.open("public/example.in");
    Out.compareTo("public/example.out");

    int n = In.readInt();
    int[] A = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = In.readInt();
    }
    Out.println(longestSubarray(n, A));
    
    // Uncomment this line if you want to read from a file
    In.close();
  }
    
  public static int longestSubarray(int n, int[] A) {
    // in my opinion is dp not needed here
    // core idea: simply count the length of the different 
    // consequtive longest segment
    int[] segmentLengths = new int[n];
    int indexSegmentLengths = 0;
    int previousInt = A[0]; 
    int currentInt = -1;
    
    for(int i=0; i<n; i++) {
      currentInt = A[i]; 
      if(currentInt == previousInt) {
        segmentLengths[indexSegmentLengths] = segmentLengths[indexSegmentLengths] + 1;
      } else {
        indexSegmentLengths++;
        segmentLengths[indexSegmentLengths] = 1;
        previousInt = currentInt;
      }
    }
    // printArray(segmentLengths);
    // this DP approach is not working => use sliding window instead
    // int max = maximumConSum(n, segmentLengths); 
    int max = slidingWindow(n, segmentLengths); 
    // System.out.println("max: " + max);
    return max;
  }
  
  public static int slidingWindow(int n, int[] segmentLengths) {
    int max = -1; 
    int pointer1 = 0;
    int pointer2 = pointer1 + 1; 
    int pointer3 = pointer2 + 1; 
    
    for(int i=0; i<n; i++) {
      if(pointer3<n) {
        int currentMax = segmentLengths[pointer1] + segmentLengths[pointer2] + segmentLengths[pointer3];
        if(currentMax > max) {
          max = currentMax; 
        }
        pointer1++;
        pointer2++;
        pointer3++;
      } else {
        break;
      }
    }
    return max;
  }
  
  public static int maximumConSum(int n, int[] segmentLengths) {
    int[] dp = new int[n+1]; 
    
    // initialization (not necessary since already given per java default)
    for(int k=0; k<n; k++) {
      dp[k] = 0;
    }
    
    // recursion
    for(int i=1; i<n; i++) {
      dp[i] = Math.max(segmentLengths[i-1], dp[i-1]+segmentLengths[i-1]);
    }
    printArray(dp);
    return dp[n-1];
  }
  
  public static void printArray(int[] A) {
    for(int entry : A) {
      System.out.println(entry);
    }
  }

  
}