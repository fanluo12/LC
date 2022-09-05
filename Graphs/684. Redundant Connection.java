class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[1001];
        for (int i = 0; i < parent.length; i ++) {
            parent[i] = i;
        }
        
        for (int[] edge: edges) {
            int from = edge[0], to = edge[1];
            if (find(from, parent) == find(to, parent)) {
                return edge;
            }
            union(from, to, parent);
        }
        return new int[2];
    }
    
    public int find(int node, int[] parent) {
        while (node != parent[node]) {
            node = parent[node];
        }
        return node;
    }
    
    public void union(int a, int b, int[] parent) {
        int aRoot = find(a, parent), bRoot = find(b, parent);
        if(aRoot == bRoot) {
            return;
        }
        
        parent[aRoot] = bRoot;
    }
}
