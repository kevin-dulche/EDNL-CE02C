/*
* Sección 3: Representación de grafos
Pregunta b (25 puntos):
Dada una representación de un grafo no dirigido, implemente un algoritmo para recorrer el grafo en anchura (BFS).
El algoritmo debe recorrer todos los nodos del grafo y marcarlos como visitados. 
La implementación debe indicar si el grafo es conexo.
*/

import java.util.LinkedList;
import java.util.Queue;

public class RepresentacionGrafos {
    public static void main(String[] args) {
        // Asi es conexo
        int[][] graph = {
            {0,1,1,0,0,1}, 
            {1,0,0,0,0,0},
            {1,0,0,1,1,1},
            {0,0,1,0,0,0},
            {0,0,1,0,0,0},
            {1,0,1,0,0,0}
        };

        // Asi no es conexo
        // int[][] graph = {
        //     {0,0,1,0,0,1}, 
        //     {0,0,0,0,0,0},
        //     {1,0,0,1,1,1},
        //     {0,0,1,0,0,0},
        //     {0,0,1,0,0,0},
        //     {1,0,1,0,0,0}
        // };

        boolean conexo = bfs(graph);
        System.out.println("El grafo es conexo: " + conexo);
    }

    public static boolean bfs(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
    
        // Iniciar la cola para el BFS
        Queue<Integer> queue = new LinkedList<>();
    
        // Empezar desde el primer nodo
        queue.add(0);
        visited[0] = true;
    
        // Recorrer todos los nodos conectados
        while (!queue.isEmpty()) {
            int current = queue.poll();
    
            // Recorrer todos los nodos adyacentes
            for (int i = 0; i < n; i++) {
                // Si el nodo no ha sido visitado y hay una conexión
                if (!visited[i] && graph[current][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    
        // Verificar si todos los nodos fueron visitados
        for (boolean v : visited) {
            if (!v) {
                return false; // No es conexo
            }
        }
        return true; // Es conexo
    }
}