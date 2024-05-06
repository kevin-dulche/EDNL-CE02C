/*
 * Sección 3: Representación de grafos
    Pregunta b (25 puntos):
    Dada una representación de un grafo no dirigido, implemente un algoritmo para recorrer el grafo en anchura (BFS).
    El algoritmo debe recorrer todos los nodos del grafo y marcarlos como visitados. 
    La implementación debe indicar si el grafo es conexo.
 */

// ! Pendiente de revisión
// ? Duda sobre la implementación de la función bfs, siempre me da que el grafo es conexo

import java.util.ArrayList;

public class RepresentacionGrafos {
    public static void main(String[] args) {
        int[][] grafo = {
            {0, 1, 1, 0, 0, 0},
            {1, 0, 0, 1, 1, 0},
            {1, 0, 0, 0, 1, 0},
            {0, 1, 0, 0, 1, 1},
            {0, 1, 1, 1, 0, 1},
            {0, 0, 0, 1, 1, 0}
        };

        //System.out.println(grafo.length);

        ArrayList<Integer> visitados = new ArrayList<>();
        for (int i = 0; i < grafo.length; i++) {
            if (!visitados.contains(i)) {
                bfs(grafo, i, visitados);
            }
        }

        if (visitados.size() == grafo.length) {
            System.out.println("El grafo es conexo");
        } else {
            System.out.println("El grafo no es conexo");
        }
    }

    public static void bfs(int[][] grafo, int nodo, ArrayList<Integer> visitados) {
        ArrayList<Integer> cola = new ArrayList<>();
        cola.add(nodo);
        visitados.add(nodo);

        while (!cola.isEmpty()) {
            int actual = cola.remove(0);
            System.out.print(actual + " ");

            for (int i = 0; i < grafo[actual].length; i++) {
                if (grafo[actual][i] == 1 && !visitados.contains(i)) {
                    cola.add(i);
                    visitados.add(i);
                }
            }
        }
    }
}