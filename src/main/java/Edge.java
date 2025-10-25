public class Edge implements Comparable<Edge> {
    int otkuda, kuda, weight;

    public Edge(int otkuda, int kuda, int weight) {
        this.otkuda = otkuda;
        this.kuda = kuda;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge drugie){
        return this.weight = drugie.weight;
    }

    @Override
    public String toString(){
        return otkuda + " " + kuda + " " + weight;
    }
}
