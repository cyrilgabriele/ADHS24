public class Factorial {
    public static void main(String[] args) {
        int n = 0;
        int result = factorial(n);
        System.out.println("result: " + result);
        
    }

    public static int factorial(int n) {
        // need to test this otherwise wrong for n=0!
        if(n==0) {
            return 1;
        }

        int factorial = n;

        for(int i=1; i<=n-1; i++) {
            factorial = factorial * (n-i);
        }

        return factorial;
    }
}
