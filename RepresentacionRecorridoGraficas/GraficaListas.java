import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class GraficaListas {
    private int vertices;
    private List<List<Integer>> adjacencyList;

    public GraficaListas(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // For undirected graphs
    }

    // Implementa método para BFS y DFS usando una lista de adyacencia

    public void DFS(GraficaListas graph, int startVertex) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.vertices];
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            if (!visited[currentVertex]) {
                System.out.print(currentVertex + " ");
                visited[currentVertex] = true;
            }

            List<Integer> neighboursList = graph.adjacencyList.get(currentVertex);
            for (int neighbour : neighboursList) {
                if (!visited[neighbour]) {
                    stack.push(neighbour);
                }
            }
        }
    }

    public void BFS(GraficaListas graph, int startVertex) {
        List<Integer> queue = new ArrayList<>();
        boolean[] visited = new boolean[graph.vertices];
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.remove(0);
            System.out.print(currentVertex + " ");

            List<Integer> neighboursList = graph.adjacencyList.get(currentVertex);
            for (int neighbour : neighboursList) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }


}