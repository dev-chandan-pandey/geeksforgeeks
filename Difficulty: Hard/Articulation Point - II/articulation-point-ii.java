import java.util.*;

class Solution {
    private int timer = 1;

    public ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // 1. Build Adjacency List
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // 2. Initialize tracking arrays
        int[] tin = new int[V];    // Time of insertion
        int[] low = new int[V];    // Lowest time reachable
        int[] vis = new int[V];    // Visited status
        boolean[] mark = new boolean[V]; // Mark identified APs
        
        // 3. Handle disconnected components
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }

        // 4. Collect and sort results
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (mark[i]) ans.add(i);
        }

        if (ans.size() == 0) ans.add(-1);
        return ans;
    }

    private void dfs(int node, int parent, int[] vis, int[] tin, int[] low, 
                     boolean[] mark, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        tin[node] = low[node] = timer++;
        int child = 0;

        for (Integer it : adj.get(node)) {
            if (it == parent) continue;
            if (vis[it] == 0) {
                dfs(it, node, vis, tin, low, mark, adj);
                low[node] = Math.min(low[node], low[it]);
                // Check AP condition
                if (low[it] >= tin[node] && parent != -1) {
                    mark[node] = true;
                }
                child++;
            } else {
                // Back-edge: Update low value with ancestor's discovery time
                low[node] = Math.min(low[node], tin[it]);
            }
        }
        // Root case
        if (child > 1 && parent == -1) {
            mark[node] = true;
        }
    }
}
