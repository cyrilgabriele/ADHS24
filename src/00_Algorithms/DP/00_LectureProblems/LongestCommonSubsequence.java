import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        // char[] A = {'T', 'I', 'G', 'E', 'R'};
        // char[] B = {'Z', 'I', 'G', 'E'};
        char[] A = {'A', 'G', 'G', 'T', 'A', 'B'};
        char[] B = {'G', 'X', 'T', 'X', 'A', 'Y', 'B'};
        int n = A.length;
        int m = B.length;
        int result = lcs(n, m, A, B);
        System.out.println("Result lcs: " + result);
    }

    public static int lcs(int n, int m, char[] A, char[] B) {
        int[][] dp = new int[n + 1][m + 1]; // Extra Platz für Basisfälle

        // Initialisierung (Basisfälle)
        for (int i = 0; i <= n; i++) dp[i][0] = 0; // 1. Fall: j == 0
        for (int j = 0; j <= m; j++) dp[0][j] = 0; // 1. Fall: i == 0

        // DP-Formel umsetzen
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (A[i - 1] == B[j - 1]) { // Zeichen stimmen überein
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { // Zeichen stimmen nicht überein
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Debug: Ausgabe der dp-Tabelle
        System.out.println("DP-Table:");
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }

        // Ergebnis zurückgeben (LCS von A und B)
        return dp[n][m];
    }
}
