import java.util.*;

public class DijkstraAlgorithm {

    public static String dijkstra(Map<Character, Map<Character, Integer>> G, char u, char v) {
        // Inicializamos las estructuras necesarias
        Map<Character, Integer> distancia = new HashMap<>();
        Map<Character, Character> previo = new HashMap<>();
        PriorityQueue<Character> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(distancia::get));

        // Inicializamos las distancias y previos
        for (char vertice : G.keySet()) {
            distancia.put(vertice, Integer.MAX_VALUE);
            previo.put(vertice, null);
        }
        distancia.put(u, 0);

        // Agregamos el vértice inicial a la cola de prioridad
        colaPrioridad.add(u);

        // Aplicamos el algoritmo de Dijkstra
        while (!colaPrioridad.isEmpty()) {
            char verticeActual = colaPrioridad.poll();
            for (char vecino : G.get(verticeActual).keySet()) {
                int distanciaAlternativa = distancia.get(verticeActual) + G.get(verticeActual).get(vecino);
                if (distanciaAlternativa < distancia.get(vecino)) {
                    distancia.put(vecino, distanciaAlternativa);
                    previo.put(vecino, verticeActual);
                    colaPrioridad.add(vecino);
                }
            }
        }

        // Reconstruimos el camino más corto desde u hasta v
        StringBuilder camino = new StringBuilder();
        Character vertice = v;
        while (vertice != null) {
            camino.insert(0, vertice + " -> ");
            vertice = previo.get(vertice);
        }

        // Devolvemos el camino más corto y su costo como una cadena
        return "Camino mas corto desde " + u + " hasta " + v + ": " + camino.toString() + " con costo: " + distancia.get(v);
    }
}