import java.util.LinkedList;
import java.util.Queue;
<<<<<<< HEAD
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FordFulkerson {
    public int V;  // Número de vértices en el grafo
    public int[][] capacidad; // Matriz de capacidad

    public FordFulkerson(int vertices) {
        this.V = vertices;
        capacidad = new int[vertices][vertices];
    }

    // Añade una arista del vértice u al vértice v con capacidad c
    public void agregarArista(int u, int v, int c) {
        capacidad[u][v] = c;
    }

    // Devuelve verdadero si hay un camino del origen al sumidero en el grafo residual
    // También llena el arreglo padre[] para almacenar el camino
    private boolean bfs(int[][] grafoResidual, int origen, int sumidero, int[] padre) {
        boolean[] visitado = new boolean[V];
=======

public class FordFulkerson {
    private Grafo grafo;

    public FordFulkerson(Grafo grafo) {
        this.grafo = grafo;
    }

    private boolean bfs(int[][] grafoResidual, int origen, int sumidero, int[] padre) {
        boolean[] visitado = new boolean[grafo.getV()];
>>>>>>> f20cc62ad8eda5559a6cfeb075420a31d76f1527
        Queue<Integer> cola = new LinkedList<>();
        cola.add(origen);
        visitado[origen] = true;
        padre[origen] = -1;

        while (!cola.isEmpty()) {
            int u = cola.poll();

<<<<<<< HEAD
            for (int v = 0; v < V; v++) {
=======
            for (int v = 0; v < grafo.getV(); v++) {
>>>>>>> f20cc62ad8eda5559a6cfeb075420a31d76f1527
                if (!visitado[v] && grafoResidual[u][v] > 0) {
                    cola.add(v);
                    padre[v] = u;
                    visitado[v] = true;
                }
            }
        }

        return visitado[sumidero];
    }

<<<<<<< HEAD
    // Devuelve el flujo máximo desde el origen al sumidero en el grafo dado
    public int fordFulkerson(int origen, int sumidero) {
        int u, v;

        // Grafo residual donde grafoResidual[i][j] indica
        // la capacidad residual de la arista de i a j
        int[][] grafoResidual = new int[V][V];

        for (u = 0; u < V; u++) {
            for (v = 0; v < V; v++) {
                grafoResidual[u][v] = capacidad[u][v];
            }
        }

        int[] padre = new int[V]; // Este arreglo es llenado por BFS y almacena el camino

        int flujoMaximo = 0;  // Inicialmente no hay flujo

        // Aumentar el flujo mientras haya un camino desde el origen al sumidero
        while (bfs(grafoResidual, origen, sumidero, padre)) {
            // Encontrar el flujo máximo a través del camino encontrado
=======
    public int fordFulkerson(int origen, int sumidero) {
        int u, v;
        int[][] grafoResidual = new int[grafo.getV()][grafo.getV()];

        for (u = 0; u < grafo.getV(); u++) {
            for (v = 0; v < grafo.getV(); v++) {
                grafoResidual[u][v] = grafo.getCapacidad()[u][v];
            }
        }

        int[] padre = new int[grafo.getV()];
        int flujoMaximo = 0;

        while (bfs(grafoResidual, origen, sumidero, padre)) {
>>>>>>> f20cc62ad8eda5559a6cfeb075420a31d76f1527
            int flujoCamino = Integer.MAX_VALUE;
            for (v = sumidero; v != origen; v = padre[v]) {
                u = padre[v];
                flujoCamino = Math.min(flujoCamino, grafoResidual[u][v]);
            }

<<<<<<< HEAD
            // Actualizar las capacidades residuales de las aristas y aristas inversas
            // a lo largo del camino
=======
>>>>>>> f20cc62ad8eda5559a6cfeb075420a31d76f1527
            for (v = sumidero; v != origen; v = padre[v]) {
                u = padre[v];
                grafoResidual[u][v] -= flujoCamino;
                grafoResidual[v][u] += flujoCamino;
            }

<<<<<<< HEAD
            // Añadir flujo del camino al flujo total
=======
>>>>>>> f20cc62ad8eda5559a6cfeb075420a31d76f1527
            flujoMaximo += flujoCamino;
        }

        return flujoMaximo;
    }
<<<<<<< HEAD

    // Leer datos de un archivo txt
    public static FordFulkerson leerGrafoDeArchivo(String rutaArchivo) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(rutaArchivo));
        int vertices = sc.nextInt();
        FordFulkerson ff = new FordFulkerson(vertices);

        while (sc.hasNextInt()) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int capacidad = sc.nextInt();
            ff.agregarArista(u, v, capacidad);
        }

        sc.close();
        return ff;
    }

    // Método principal (main)
    public static void main(String[] args) {
        try {
            FordFulkerson ff = FordFulkerson.leerGrafoDeArchivo("ruta/del/archivo.txt");

            // Visualizar grafo antes de calcular flujo máximo
            System.out.println("Grafo antes de calcular flujo máximo:");
            ff.imprimirGrafo();

            int flujoMaximo = ff.fordFulkerson(0, 5);
            System.out.println("El flujo máximo posible es " + flujoMaximo);

            // Visualizar grafo después de calcular flujo máximo
            System.out.println("Grafo después de calcular flujo máximo:");
            ff.imprimirGrafo();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        }
    }

    // Método para imprimir el grafo
    public void imprimirGrafo() {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (capacidad[i][j] > 0) {
                    System.out.println("Arista de " + i + " a " + j + " con capacidad " + capacidad[i][j]);
                }
            }
        }
    }
=======
>>>>>>> f20cc62ad8eda5559a6cfeb075420a31d76f1527
}
