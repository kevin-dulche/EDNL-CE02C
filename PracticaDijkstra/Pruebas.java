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
    }
}