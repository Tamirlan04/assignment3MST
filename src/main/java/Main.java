import com.google.gson.*;
import java.io.*;
import java.util.*;

public class Main {
    class GraphsData {
        List<GraphInput> graphs;
    }

    class GraphInput {
        int id;
        List<String> nodes;
        List<EdgeInput> edges;
    }

    class EdgeInput {
        String otkuda;
        String kuda;
        int weight;
    }

    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();

        GraphInput input = gson.fromJson(new FileReader("data/input.json"), GraphInput.class);
        Graph graph = new Graph(input.nodes.size());
        for (GraphInput gInput : GraphsData.graphs) {
            Graph graph = new Graph(gInput.nodes.size());

            for (EdgeInput e : gInput.edges) {
                int u = gInput.nodes.indexOf(e.otkuda);
                int v = gInput.nodes.indexOf(e.kuda);
                graph.addEdge(u, v, e.weight);
            }

            var primResult = Prim.run(graph);
            var kruskalResult = Kruskal.run(graph);

            }


        Map<String, Object> primResult = Prim.run(graph);
        Map<String, Object> kruskalResult = Kruskal.run(graph);

        Map<String, Object> results = new LinkedHashMap<>();
        results.put("Prim", primResult);
        results.put("Kruskal", kruskalResult);

        FileWriter writer = new FileWriter("data/output.json");
        gson.toJson(results, writer);
        writer.close();

        System.out.println("✅ Prim and Kruskal completed successfully!");
        System.out.println("Prim total cost: " + primResult.get("total_cost"));
        System.out.println("Kruskal total cost: " + kruskalResult.get("total_cost"));
    }
}
