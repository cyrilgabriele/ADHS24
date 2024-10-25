public class QuickSort {
    public static void main(String[] args) {
        int [] A = {5, 8, 2, 15, 20, 3, 5, 3, 55, 6}; 
        int left = 0; 
        int right = A.length-1;
        int [] sortedA = quicksort(A, left, right);

        for(int i=0; i < A.length; ++i) {
            System.out.println(sortedA[i]);
        }

    }

    public static int [] quicksort(int [] A, int left, int right) {
        if (left < right) {
            int k = partition(A, left, right);
            quicksort(A, left, k-1);
            quicksort(A, k+1, right);
        }
        return A; 
    }

    public static int partition(int [] A, int left, int right) {
        int i = left; 
        int j = right - 1;
        int pivot = A[right]; //right-most element of A is the pivot element 
        
        while(j>=i) {
            while(i < right && A[i] <= pivot) {
                i++;
            }
            while(j >= left && A[j] > pivot) {
                j--;
            }
            if(i<j) {
                swap(A, i, j);
            } 
        }
        swap(A, i, right);
        return i;
    }

    public static void swap(int [] A, int i, int j) {
        int swapElement = A[i]; 
        A[i] = A[j];
        A[j] = swapElement;
    }
}

