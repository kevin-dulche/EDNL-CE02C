import java.io.FileNotFoundException;

class PrimAlgorithm {
    private int vertices;

    PrimAlgorithm(int vertices) {
        this.vertices = vertices;
    }

    int findMinKeyVertex(double keys[], Boolean setOfMST[]) {
        int minIndex = -1;
        double minValue = Integer.MAX_VALUE;

        for (int vertex = 0; vertex < vertices; vertex++) {
            if (!setOfMST[vertex] && keys[vertex] < minValue) {
                minValue = keys[vertex];
                minIndex = vertex;
            }
        }

        return minIndex;
    }

    void showMinimumSpanningTree(int mstArray[], double graphArray[][]) {
        System.out.println("Edge \t Weight");
        for (int j = 1; j < vertices; j++) {
            System.out.println(mstArray[j] + " <-> " + j + "\t " + graphArray[j][mstArray[j]]);
        }
    }

    void designMST(double graphArray[][]) {
        int[] mstArray = new int[vertices];
        double[] keys = new double[vertices]; // Cambio de int a double
        Boolean[] setOfMST = new Boolean[vertices];
    
        for (int j = 0; j < vertices; j++) {
            keys[j] = Double.MAX_VALUE; // Cambio de Integer.MAX_VALUE a Double.MAX_VALUE
            setOfMST[j] = false;
        }
    
        keys[0] = 0;
        mstArray[0] = -1;
    
        for (int i = 0; i < vertices - 1; i++) {
            int edge = findMinKeyVertex(keys, setOfMST);
            setOfMST[edge] = true;
    
            for (int vertex = 0; vertex < vertices; vertex++) {
                if (graphArray[edge][vertex] != 0 && !setOfMST[vertex] && graphArray[edge][vertex] < keys[vertex]) {
                    mstArray[vertex] = edge;
                    keys[vertex] = graphArray[edge][vertex];
                }
            }
        }
    
        // Corregir la invocación del método showMinimumSpanningTree
        showMinimumSpanningTree(mstArray, graphArray);
    }
    
    

    public static void main(String[] args) {
        try {
            GraphReader.Graph graph = GraphReader.readGraphFromFile("../data/Range_150/ins_500_3.txt");
            double[][] graphArray = new double[graph.nodes][graph.nodes];
            for (GraphReader.Edge e : graph.edgeList) {
                graphArray[e.source][e.destination] = e.weight;
                graphArray[e.destination][e.source] = e.weight;
            }
            PrimAlgorithm prim = new PrimAlgorithm(graph.nodes);
            prim.designMST(graphArray);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
