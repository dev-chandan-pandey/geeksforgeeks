import java.util.*;

class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        // Base case: If there is only one node, it is the root
        if (V == 1) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }

        // 1. Build the Adjacency List and Degree array
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] degree = new int[V];
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        // 2. Add all initial leaf nodes (degree 1) to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }

        // 3. Trim leaves layer-by-layer until 1 or 2 nodes remain
        int remainingNodes = V;
        while (remainingNodes > 2) {
            int currentLayerSize = queue.size();
            remainingNodes -= currentLayerSize;
            
            for (int i = 0; i < currentLayerSize; i++) {
                int leaf = queue.poll();
                
                // For each neighbor of the leaf, reduce its degree
                for (int neighbor : adj.get(leaf)) {
                    degree[neighbor]--;
                    // If the neighbor becomes a new leaf, add it to the next layer
                    if (degree[neighbor] == 1) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        // 4. The remaining nodes in the queue are the center(s)
        ArrayList<Integer> result = new ArrayList<>(queue);
        Collections.sort(result); // Optional: sort if the problem requires it
        return result;
    }
}
