public class UnionFind {

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];

        // initialization
        for(int i=0; i<n; i++) {
            parent[i] = i; // in the begining everybody is its own parent
            rank[i] = 0; // in the beginning only one node => rank = 0 
        }
    }

    public int find(int rep) {
        if(rep != parent[rep]) {
            parent[rep] = find(rep);
        }
        return parent[rep];      
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
