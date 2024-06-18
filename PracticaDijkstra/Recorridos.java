import java.util.*;

public class Recorridos {

    public static String recorridoEnProfundidad(Map<Character, List<Character>> G, char u) {
        // Inicializamos las variables necesarias
        Set<Character> visitados = new HashSet<>();
        StringBuilder recorrido = new StringBuilder();
        
        // Llamamos a la función auxiliar para realizar el recorrido en profundidad
        recorridoEnProfundidadAux(G, u, visitados, recorrido);
        
        // Devolvemos el recorrido por profundidad como una cadena
        return recorrido.toString();
    }
    
    private static void recorridoEnProfundidadAux(Map<Character, List<Character>> G, char u, Set<Character> visitados, StringBuilder recorrido) {
        // Marcamos el vértice actual como visitado y lo agregamos al recorrido
        visitados.add(u);
        recorrido.append(u).append(" -> ");
        
        // Recorremos los vecinos del vértice actual
        for (char vecino : G.get(u)) {
            if (!visitados.contains(vecino)) {
                recorridoEnProfundidadAux(G, vecino, visitados, recorrido);
            }
        }
    }

    public static String recorreEnAmplitud(Map<Character, List<Character>> G, char u) {
        // Inicializamos las variables necesarias
        Set<Character> visitados = new HashSet<>();
        StringBuilder recorrido = new StringBuilder();
        Queue<Character> cola = new LinkedList<>();
        
        // Comenzamos el recorrido por amplitud
        cola.add(u);
        while (!cola.isEmpty()) {
            char verticeActual = cola.poll();
            if (!visitados.contains(verticeActual)) {
                recorrido.append(verticeActual).append(" -> ");
                visitados.add(verticeActual);
                // Agregamos los vecinos no visitados a la cola
                for (char vecino : G.get(verticeActual)) {
                    if (!visitados.contains(vecino)) {
                        cola.add(vecino);
                    }
                }
            }
        }
        
        // Devolvemos el recorrido por amplitud como una cadena
        return recorrido.toString();
    }
}