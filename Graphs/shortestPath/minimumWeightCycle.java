class Solution {
    public int findMinCycle(int V, int[][] edges) {
        int INF = (int) 1e9;
        int[][] dist = new int[V][V];

        // Initialize distances
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        // Add all edges to the graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        int minCycle = INF;

        // For each edge, try removing it and find the shortest path between u and v
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            // Temporarily remove edge (u, v)
            dist[u][v] = INF;
            dist[v][u] = INF;

            // Use Floyd-Warshall to find shortest paths
            int[][] tempDist = new int[V][V];
            for (int i = 0; i < V; i++)
                tempDist[i] = dist[i].clone();

            for (int k = 0; k < V; k++) {
                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < V; j++) {
                        if (tempDist[i][k] < INF && tempDist[k][j] < INF)
                            tempDist[i][j] = Math.min(tempDist[i][j], tempDist[i][k] + tempDist[k][j]);
                    }
                }
            }

            // Check if path between u and v exists
            if (tempDist[u][v] < INF) {
                minCycle = Math.min(minCycle, tempDist[u][v] + w);
            }

            // Restore the edge
            dist[u][v] = w;
            dist[v][u] = w;
        }

        return minCycle == INF ? -1 : minCycle;
    }
}
