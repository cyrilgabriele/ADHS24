public class SubsetSum {
    public static void main(String[] args) {
        int[] A = {5, 3, 10, 7, 3, 1};
        int n = A.length;
        int s = 2;
        boolean isSpossible = naiveSubsetSum(n, A, s);
        System.out.println("subset sum is possible: " + isSpossible);
        
    }

    public static boolean subsetSum() {
        return true;
    }

    public static boolean naiveSubsetSum(int n, int[] A, int s) {
        // BASE CASEs
        // subset sum is 0 => reached the sum aka possible    
        if (s==0) {return true;};
        // no elements in Array A aka only subset sum possible is 0
        if (n==0 || s < 0) {return false;};

        // ignore current element if element > s 
        if (A[n - 1] > s) {return naiveSubsetSum(n - 1, A, s);};        

        // (naive) recursion: take element || do NOT take it 
        // => then call with n-1 and either the adjusted s or the unaltered s if A[n] not taken
        return naiveSubsetSum(n-1, A, s - A[n-1]) || naiveSubsetSum(n-1, A, s);
    }
    
}
