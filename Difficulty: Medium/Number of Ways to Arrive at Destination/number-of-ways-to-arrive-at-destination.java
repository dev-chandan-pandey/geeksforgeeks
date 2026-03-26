import java.util.*;

class Solution {
    public int countPaths(int V, int[][] edges) {
        // Adjacency list: u -> list of {v, weight}
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        long[] dist = new long[V];
        int[] ways = new int[V];
        Arrays.fill(dist, Long.MAX_VALUE);
        
        // Priority Queue stores {distance, node}
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        dist[0] = 0;
        ways[0] = 1;
        pq.add(new long[]{0, 0});
        int mod = (int) (1e9 + 7);

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long d = current[0];
            int u = (int) current[1];

            if (d > dist[u]) continue;

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                // Found a strictly shorter path
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    ways[v] = ways[u];
                    pq.add(new long[]{dist[v], v});
                } 
                // Found another path with the same minimum distance
                else if (dist[u] + weight == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % mod;
                }
            }
        }
        return ways[V - 1];
    }
}
