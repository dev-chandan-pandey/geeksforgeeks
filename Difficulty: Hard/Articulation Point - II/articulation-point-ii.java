//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.articulationPoints(V, edges);
            Collections.sort(ans);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        ArrayList<Integer> articulationPoints = new ArrayList<>();
        int[] disc = new int[V];
        int[] low = new int[V];
        int time = 0;
        boolean[] visited = new boolean[V];
        boolean[] isAP = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, disc, low, visited, isAP, time, adj);
            }
        }

        for (int i = 0; i < V; i++) {
            if (isAP[i]) {
                articulationPoints.add(i);
            }
        }

        if (articulationPoints.isEmpty()) {
            articulationPoints.add(-1);
        }
        Collections.sort(articulationPoints);
        return articulationPoints;
    }

    private static void dfs(int u, int p, int[] disc, int[] low, boolean[] visited, boolean[] isAP, int time, ArrayList<ArrayList<Integer>> adj) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int neighbor : adj.get(u)) {
            if (neighbor == p) continue;

            if (visited[neighbor]) {
                low[u] = Math.min(low[u], disc[neighbor]);
            } else {
                dfs(neighbor, u, disc, low, visited, isAP, time, adj);
                low[u] = Math.min(low[u], low[neighbor]);
                if (low[neighbor] >= disc[u] && p != -1) {
                    isAP[u] = true;
                }
                children++;
            }
        }

        if (p == -1 && children > 1) {
            isAP[u] = true;
        }
    }
}