class Solution {
    
       static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited) {
      
        // mark as visiting
        visited[node] = 1;
        
        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 1) {
                // cycle detected
                return false;
            } else if (visited[neighbor] == 0) {
                if (!dfs(neighbor, adj, visited)) {
                    return false;
                }
            }
        }
        
        // mark as visited
        visited[node] = 2;
        return true;
    }
    
    public boolean canFinish(int n, int[][] prerequisites) {
        // code here
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int dest = pre[0];
            int src = pre[1];
            adj.get(src).add(dest);
        }
        
        // 0 = unvisited, 1 = visiting, 2 = visited
        int[] visited = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, adj, visited)) {
                    // cycle detected
                    return false;
                }
            }
        }
        
        return true;
    }
}