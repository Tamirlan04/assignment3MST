import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

class EdgeInput {
    String from;
    String to;
    int weight;
}

class GraphInput {
    int id;
    List<String> nodes;
    List<EdgeInput> edges;
}

class GraphsData {
    List<GraphInput> graphs;
}

public class Main {
    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();

        GraphsData graphsData = gson.fromJson(new FileReader("data/input.json"), GraphsData.class);

        if (graphsData == null || graphsData.graphs == null) {
            System.err.println("Error: No graphs in input file.");
            return;
        }

        Map<String, Object> allResults = new LinkedHashMap<>();

        for (GraphInput gInput : graphsData.graphs) {
            if (gInput == null || gInput.nodes == null || gInput.edges == null) {
                System.err.println("Empty or invalid graph. Skip.");
                continue;
            }

            System.out.println("Proccessing graph " + gInput.id +
                    " (" + gInput.nodes.size() + " vertices, " + gInput.edges.size() + " edges)");

            Graph graph = new Graph(gInput.nodes.size());

            for (EdgeInput e : gInput.edges) {
                if (e == null) continue;

                int u = gInput.nodes.indexOf(e.from);
                int v = gInput.nodes.indexOf(e.to);

                if (u == -1 || v == -1) {
                    System.err.println("Error: vertice did't find " + e.from + " or " + e.to + " in graph " + gInput.id);
                    continue;
                }

                graph.addEdge(u, v, e.weight);
            }

            Map<String, Object> primResult = Prim.run(graph);
            Map<String, Object> kruskalResult = Kruskal.run(graph);

            Map<String, Object> result = new LinkedHashMap<>();
            result.put("Prim", primResult);
            result.put("Kruskal", kruskalResult);

            allResults.put("Graph_" + gInput.id, result);
        }

        FileWriter writer = new FileWriter("data/output.json");
        gson.toJson(allResults, writer);
        writer.close();

        System.out.println("results saved in data/output.json");
    }
}

