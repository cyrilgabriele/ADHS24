public class UnionFind {

    public int[] parent;
    public int[] rank;

    public UnionFind(int n) {
        int[] parent = new int[n];
        int[] rank = new int[n];

        // initialization
        for(int i=0; i<n; i++) {
            parent[i] = i; // in the begining everybody is its own parent
            rank[i] = 0; // in the beginning only one node => rank = 0 
        }
    }

    public int find(int elem1) {
        if(elem1 != parent[elem1]) {
            parent[elem1] = find(elem1);
        }
        return parent[elem1];      
    }

    public void union(int elem1, int elem2) {
        int root1 = find(elem1); 
        int root2 = find(elem2);

        if(rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }
    } 
}
