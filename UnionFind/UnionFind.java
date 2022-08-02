public class UnionFind {

    public int[] id;
    public int[] sz;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        id = new int[n];
        sz = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        if(vertex >= id.length){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        return sz[find(v1)];
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        if(v1 == id[v1]){
            return -1;
        }
        return id[v1];
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        return find(v1) == find(v2);
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a
       vertex with itself or vertices that are already connected should not
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        validate(v1);
        validate(v2);
        // Task 1: find its set
        int set1 = find(v1);
        int set2 = find(v2);
        // Task 2: compare the size of the two sets and union
        // Task 3: prepare for the next union
        if(sizeOf(v1) > sizeOf(v2)){
            id[id[set2]] = set1;
            sz[set1] += sz[set2];
            sz[set2]  = 1;
        }else{
            id[id[set1]] = set2;
            sz[set2] += sz[set1];
            sz[set1]  = 1;
        }


    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        if(id[vertex] == vertex){
            return vertex;
        }
        else{
            return find(id[vertex]);
        }
    }

}
