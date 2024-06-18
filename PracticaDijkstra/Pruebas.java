import java.util.*;

public class Pruebas {
    public static void main(String[] args) {
        // Ejemplo de uso
        Map<Character, List<Character>> G = new HashMap<>();
        G.put('1', Arrays.asList('2', '4'));
        G.put('2', Arrays.asList('3', '4'));
        G.put('3', Arrays.asList('4'));
        G.put('4', Arrays.asList('5'));
        G.put('5', Arrays.asList('3'));
        
        char inicio = '1';
        System.out.println("Recorrido en profundidad desde " + inicio + ": " + Recorridos.recorridoEnProfundidad(G, inicio));
        System.out.println("Recorrido en amplitud desde " + inicio + ": " + Recorridos.recorreEnAmplitud(G, inicio));

        Map<Character, Map<Character, Integer>> G2 = new HashMap<>();
        G2.put('A', new HashMap<>());
        G2.get('A').put('B', 16);
        G2.get('A').put('C', 10);
        G2.get('A').put('D', 5);
        G2.put('B', new HashMap<>());
        G2.get('B').put('A', 16);
        G2.get('B').put('C', 2);
        G2.get('B').put('G', 6);
        G2.get('B').put('F', 4);
        G2.put('C', new HashMap<>());
        G2.get('C').put('A', 10);
        G2.get('C').put('B', 2);
        G2.get('C').put('D', 4);
        G2.get('C').put('F', 12);
        G2.get('C').put('E', 10);
        G2.put('D', new HashMap<>());
        G2.get('D').put('A', 5);
        G2.get('D').put('C', 4);
        G2.get('D').put('E', 15);
        G2.put('E', new HashMap<>());
        G2.get('E').put('C', 10);
        G2.get('E').put('D', 15);
        G2.get('E').put('F', 3);
        G2.get('E').put('Z', 5);
        G2.put('F', new HashMap<>());
        G2.get('F').put('B', 4);
        G2.get('F').put('C', 12);
        G2.get('F').put('E', 3);
        G2.get('F').put('Z', 16);
        G2.get('F').put('G', 8);
        G2.put('G', new HashMap<>());
        G2.get('G').put('B', 6);
        G2.get('G').put('F', 8);
        G2.get('G').put('Z', 7);
        G2.put('Z', new HashMap<>());
        G2.get('Z').put('E', 5);
        G2.get('Z').put('F', 16);
        G2.get('Z').put('G', 7);

        char inicio2 = 'A';
        char fin2 = 'Z';

        System.out.println(DijkstraAlgorithm.dijkstra(G2, inicio2, fin2));
    }
}