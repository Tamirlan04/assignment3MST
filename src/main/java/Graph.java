import java.util.*;

public class Graph {
    int vertice;
    List<Edge> edges;

    public Graph(int vertices){
        this.vertice = vertices;
        edges = new ArrayList<>();
    }

    public void addEdge(int otkuda, int kuda, int weight){
        edges.add(new Edge(otkuda, kuda, weight));
    }

    public List<Edge> getEdges(){
        return edges;
    }
}
