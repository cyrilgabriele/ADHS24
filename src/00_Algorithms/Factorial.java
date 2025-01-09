public class Factorial {
    public static void main(String[] args) {
        int n = 10;
        int result = factorial(n);
        System.out.println("result: " + result);
        
    }

    public static int factorial(int n) {
        int factorial = n;

        for(int i=1; i<=n-1; i++) {
            factorial = factorial * (n-i);
        }

        return factorial;
    }
}
