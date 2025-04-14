import java.util.*;

public class ConnectedComponentsDFS {
    static void dfs(int node, List<List<Integer>> graph, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }

    public static void main(String[] args) {
        int n = 6; // number of nodes
        int[][] edges = {
            {0, 1},
            {1, 2},
            {3, 4}
        };

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]); // undirected graph
        }

        boolean[] visited = new boolean[n];
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, graph, visited, component);
                components.add(component);
            }
        }

        for (List<Integer> comp : components) {
            System.out.println(comp);
        }
    }
}
