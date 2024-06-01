import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {
    private Grafo grafo;

    public FordFulkerson(Grafo grafo) {
        this.grafo = grafo;
    }

    private boolean bfs(int[][] grafoResidual, int origen, int sumidero, int[] padre) {
        boolean[] visitado = new boolean[grafo.getV()];
        Queue<Integer> cola = new LinkedList<>();
        cola.add(origen);
        visitado[origen] = true;
        padre[origen] = -1;

        while (!cola.isEmpty()) {
            int u = cola.poll();

            for (int v = 0; v < grafo.getV(); v++) {
                if (!visitado[v] && grafoResidual[u][v] > 0) {
                    cola.add(v);
                    padre[v] = u;
                    visitado[v] = true;
                }
            }
        }

        return visitado[sumidero];
    }

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
            int flujoCamino = Integer.MAX_VALUE;
            for (v = sumidero; v != origen; v = padre[v]) {
                u = padre[v];
                flujoCamino = Math.min(flujoCamino, grafoResidual[u][v]);
            }

            for (v = sumidero; v != origen; v = padre[v]) {
                u = padre[v];
                grafoResidual[u][v] -= flujoCamino;
                grafoResidual[v][u] += flujoCamino;
            }

            flujoMaximo += flujoCamino;
        }

        return flujoMaximo;
    }
}
