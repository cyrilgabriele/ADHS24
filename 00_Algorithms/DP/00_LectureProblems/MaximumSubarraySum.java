public class MaximumSubarraySum {
    public static void main(String[] args) {
        int [] A = {2, -4, 3, 1, -2, 4, 2};
        int n = A.length;
        int result = maximumSubarraySum(n, A);
        System.out.println("result: " + result);
    }

    public static int maximumSubarraySum(int n, int [] A) {
        int [] dp = new int [n];

        for(int i=0; i<=n-1; ++i) {
            // BASE CASE:
            if(i==0) {
                dp[0] = A[0];
            } else {
                // 1. option: only take the current A[i] element of the array A 
                // 2. option: accumulate the current A[i] element 
                dp[i] = Math.max(A[i], dp[i-1]+A[i]);
            }
        }
        return dp[n-1]; 
    }
}
