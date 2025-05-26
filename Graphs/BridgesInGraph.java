import java.util.*;

public class BridgeFinder {
    int time = 0;
    List<List<Integer>> bridges = new ArrayList<>();

    public List<List<Integer>> findBridges(int n, List<List<Integer>> graph) {
        int[] disc = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(disc, -1);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, visited, disc, low, graph);
            }
        }

        return bridges;
    }

    private void dfs(int u, int parent, boolean[] visited, int[] disc, int[] low, List<List<Integer>> graph) {
        visited[u] = true;
        disc[u] = low[u] = time++;

        for (int v : graph.get(u)) {
            if (v == parent) continue;

            if (!visited[v]) {
                dfs(v, u, visited, disc, low, graph);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    bridges.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
