import java.io.FileNotFoundException;
import java.util.Arrays;

class KruskalAlgorithm {
    class Edge implements Comparable<Edge> {
        int source, destination;
        double weight; // Cambio de int a double para los pesos

        public int compareTo(Edge edgeToCompare) {
            return Double.compare(this.weight, edgeToCompare.weight);
        }
    }

    class Subset {
        int parent, value;
    }

    int vertices, edges;
    Edge edgeArray[];

    KruskalAlgorithm(GraphReader.Graph graph) {
        this.vertices = graph.nodes;
        this.edges = graph.edges;
        edgeArray = new Edge[graph.edges];
        for (int i = 0; i < graph.edges; ++i) {
            GraphReader.Edge e = graph.edgeList.get(i);
            edgeArray[i] = new Edge();
            edgeArray[i].source = e.source;
            edgeArray[i].destination = e.destination;
            edgeArray[i].weight = e.weight;
        }
    }

    void applyKruskal() {
        Edge finalResult[] = new Edge[vertices];
        int newEdge = 0;
        int index = 0;

        for (index = 0; index < vertices; ++index)
            finalResult[index] = new Edge();

        Arrays.sort(edgeArray);

        Subset subsetArray[] = new Subset[vertices];

        for (index = 0; index < vertices; ++index)
            subsetArray[index] = new Subset();

        for (int vertex = 0; vertex < vertices; ++vertex) {
            subsetArray[vertex].parent = vertex;
            subsetArray[vertex].value = 0;
        }
        index = 0;

        while (newEdge < vertices - 1) {
            Edge nextEdge = edgeArray[index++];

            int nextSource = findSetOfElement(subsetArray, nextEdge.source);
            int nextDestination = findSetOfElement(subsetArray, nextEdge.destination);

            if (nextSource != nextDestination) {
                finalResult[newEdge++] = nextEdge;
                performUnion(subsetArray, nextSource, nextDestination);
            }
        }
        for (index = 0; index < newEdge; ++index)
            System.out.println(finalResult[index].source + " - " + finalResult[index].destination + ": "
                    + finalResult[index].weight);
    }

    int findSetOfElement(Subset subsetArray[], int i) {
        if (subsetArray[i].parent != i)
            subsetArray[i].parent = findSetOfElement(subsetArray, subsetArray[i].parent);
        return subsetArray[i].parent;
    }

    void performUnion(Subset subsetArray[], int sourceRoot, int destinationRoot) {
        int nextSourceRoot = findSetOfElement(subsetArray, sourceRoot);
        int nextDestinationRoot = findSetOfElement(subsetArray, destinationRoot);

        if (subsetArray[nextSourceRoot].value < subsetArray[nextDestinationRoot].value)
            subsetArray[nextSourceRoot].parent = nextDestinationRoot;
        else if (subsetArray[nextSourceRoot].value > subsetArray[nextDestinationRoot].value)
            subsetArray[nextDestinationRoot].parent = nextSourceRoot;
        else {
            subsetArray[nextDestinationRoot].parent = nextSourceRoot;
            subsetArray[nextSourceRoot].value++;
        }
    }

    public static void main(String[] args) {
        try {
            GraphReader.Graph graph = GraphReader.readGraphFromFile("../data/Range_150/ins_500_3.txt");
            KruskalAlgorithm kruskal = new KruskalAlgorithm(graph);
            kruskal.applyKruskal();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

