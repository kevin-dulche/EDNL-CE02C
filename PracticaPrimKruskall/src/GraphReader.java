import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GraphReader {
    static class Edge {
        int source, destination;
        double weight;

        Edge(int source, int destination, double weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int nodes, edges;
        List<Edge> edgeList;

        Graph(int nodes, int edges) {
            this.nodes = nodes;
            this.edges = edges;
            this.edgeList = new ArrayList<>();
        }
    }

    public static Graph readGraphFromFile(String filePath) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filePath));
        int nodes = sc.nextInt();
        int edges = sc.nextInt();
        Graph graph = new Graph(nodes, edges);
        while (sc.hasNextInt()) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            double weight = sc.nextDouble(); // Cambiar a nextDouble para leer pesos decimales
            graph.edgeList.add(new Edge(source, destination, weight));
        }
        sc.close();
        return graph;
    }

}
