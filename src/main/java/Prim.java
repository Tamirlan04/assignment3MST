import java.util.*;
import java.time.*;

public class Prim {
    public static Map<String, Object> run(Graph graph) {
        long startTime = System.currentTimeMillis();
        int vertice = graph.vertice;
        boolean[] visited = new boolean[vertice];
        int operations = 0;
        List<Edge> mst = new ArrayList<>();
        int totalCost = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        visited[0] = true;
        for (Edge edge : graph.getEdges()){
            if (edge.otkuda == 0) pq.add(edge);
        }

        while (!pq.isEmpty() && mst.size() < vertice - 1) {
            Edge edge = pq.poll();
            operations++;
            if (visited[edge.kuda]) continue;

            visited[edge.kuda] = true;
            mst.add(edge);
            totalCost += edge.weight;

            for (Edge edgedrugoi : graph.getEdges()) {
                if (edgedrugoi.otkuda == edge.kuda && !visited[edgedrugoi.kuda]) pq.add(edgedrugoi);
                if (edgedrugoi.kuda == edge.kuda && !visited[edgedrugoi.otkuda])
                    pq.add(new Edge(edgedrugoi.kuda, edgedrugoi.otkuda, edgedrugoi.weight));

            }
        }
        long endTime = System.currentTimeMillis();

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("algorithm", "Prim");
        result.put("edges", mst);
        result.put("total_cost", totalCost);
        result.put("operations", operations);
        result.put("execution_time_ms", endTime - startTime);

        return result;
    }
}
