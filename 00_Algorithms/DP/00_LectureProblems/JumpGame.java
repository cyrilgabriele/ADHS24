import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
        int [] A = {1, 3, 5, 3, 2, 1, 2, 4, 4, 2, 9};
        int n = A.length;
        // int result = jumpGameV1(n, A);
        // int result = jumpGameV2(n, A);
        int result = jumpGameV3(n, A);

        // CUSTOM IS NOT WORKING:
        // int result = jumpGameCustom(n, A);
        System.out.println("result: " + result);
    }

    // O(n^2) 
    // Subproblem: min # of jumps to reach A[i] => dp[i]
    // Recurrence: min{dp[i-1]+1, dp[j..(i-1)]}
    public static int jumpGameV1(int n, int [] A) {
        int [] dp = new int [n];
        // elegant initialization of an array
        Arrays.fill(dp, Integer.MAX_VALUE/2);

        // BASE CASE 1:
        dp[0] = 0;

        // DP Algorithm
        for(int i=1; i<n; ++i){
            dp[i] = Integer.MAX_VALUE/2;
            for(int j=0; j<i; ++j){
                if(j + A[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }; 
            }
        }
        /*
        // for debug or analyzation purposes
        for(int k=0; k<n;++k){
            System.out.println(dp[k]);
        }
        */
        return dp[n-1];
    }

    // O(n^2)
    public static int jumpGameV2(int n, int[] A) {
        // Schritt 1: Initialisierung
        int k = 0;  // Anzahl der Sprünge
        int[] M = new int[n]; // Speichert den maximal erreichbaren Index für jedes k
        M[0] = 0; // M[0] = 1 (0-basiert hier also M[0] = Index 0 erreichbar)

        // Schritt 2: Berechnung von M[k]
        while (M[k] < n - 1) { // Solange der Zielindex nicht erreicht wird
            k++; // Erhöhe die Anzahl der Sprünge
            M[k] = M[k - 1]; // Startwert von M[k] ist der Wert von M[k-1]

            for (int i = 0; i <= M[k - 1]; i++) { // Alle Indizes bis M[k-1]
                M[k] = Math.max(M[k], i + A[i]); // Aktualisiere den maximal erreichbaren Index
            }

            // Falls kein Fortschritt möglich ist, brich ab (Fehlerfall)
            if (M[k] == M[k - 1]) {
                return -1; // Ziel kann nicht erreicht werden
            }
        }

        // Schritt 3: Ergebnis zurückgeben
        return k; // Minimale Anzahl der Sprünge
    }

    // O(n) => fastest version
    public static int jumpGameV3(int n, int[] A) {
        // Schritt 1: Initialisierung
        int k = 0;  // Anzahl der Sprünge
        int[] M = new int[n]; // Speichert den maximal erreichbaren Index für jedes k
        M[0] = 0; // M[0] = Index 0 erreichbar
        if (n == 1) return 0; // Spezialfall: Schon am Ziel

        // Schritt 2: Berechnung von M[k]
        while (M[k] < n - 1) { // Solange der Zielindex nicht erreicht wird
            k++; // Erhöhe die Anzahl der Sprünge

            int start = (k == 1) ? 0 : M[k - 2] + 1; // Startindex für M[k]
            M[k] = M[k - 1]; // Startwert von M[k] ist der Wert von M[k-1]

            for (int i = start; i <= M[k - 1]; i++) { // Betrachte nur relevante Indizes
                M[k] = Math.max(M[k], i + A[i]); // Aktualisiere den maximal erreichbaren Index
            }

            // Falls kein Fortschritt möglich ist, brich ab (Fehlerfall)
            if (M[k] == M[k - 1]) {
                return -1; // Ziel kann nicht erreicht werden
            }
        }

        // Schritt 3: Ergebnis zurückgeben
        return k; // Minimale Anzahl der Sprünge
    }


    // this version is my custom approach without respect to the script or lecture approaches
    public static int jumpGameCustom(int n, int [] A) {
        int [] dp = new int [n];
        // BASE CASE:
        dp[0] = 0;
        // Initialization of the dp table (for m>0)
        for(int m=1; m<n; ++m) {
            dp[m] = Integer.MAX_VALUE/2;
        }

        for(int i=1; i<n; ++i) {
            int maxReach = A[i];
            for(int j=maxReach; j<n; ++j) {
                dp[i] = dp[i-1] + 1;  
            }
        }

        for(int k=0; k<n;++k){
            System.out.println(dp[k]);
        }

        return dp[n-1];
    }
}
