import java.util.*;

public class Kruskal {
    static class DisjointSet {
        int[] parent, rank;

        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int i) {
            if (parent[i] != i)
                parent[i] = find(parent[i]);
            return parent[i];
        }

        boolean union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY) return false;

            if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    public static Map<String, Object> run(Graph graph) {
        long start = System.currentTimeMillis();
        List<Edge> edges = new ArrayList<>(graph.getEdges());
        Collections.sort(edges);
        List<Edge> mst = new ArrayList<>();
        int totalCost = 0, operations = 0;

        DisjointSet ds = new DisjointSet(graph.vertice);

        for (Edge edge : edges) {
            operations++;
            if (ds.union(edge.otkuda, edge.kuda)) {
                mst.add(edge);
                totalCost += edge.weight;
            }
            if (mst.size() == graph.vertice - 1) break;
        }

        long end = System.currentTimeMillis();

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("algorithm", "Kruskal");
        result.put("edges", mst);
        result.put("total_cost", totalCost);
        result.put("operations", operations);
        result.put("execution_time_ms", end - start);

        return result;
    }
}
