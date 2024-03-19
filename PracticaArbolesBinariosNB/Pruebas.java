import java.util.HashSet;
import java.util.Random;

public class Pruebas {
    public static void main(String[] args) {
        UnbalancedBinarySearchTree arbol = new UnbalancedBinarySearchTree();
        
        Random rand = new Random();
        HashSet<Integer> numerosGenerados = new HashSet<>();

        // Número de elementos aleatorios únicos que deseas agregar al árbol
        int cantidadElementos = 2147483647;

        // Agregar números aleatorios únicos al árbol
        while (numerosGenerados.size() < cantidadElementos) {
            int valor = rand.nextInt(cantidadElementos); // Genera números aleatorios entre 0 y 99
            if (!numerosGenerados.contains(valor)) {
                arbol.insert(valor);
                numerosGenerados.add(valor);
                System.out.println("Agregando " + valor + " al arbol");
            }
        }

        // Imprimir el árbol
        System.out.println("Preorden:");
        arbol.preorderTraversal(arbol.getRoot());
        
        System.out.println("\nInorden:");
        arbol.inorderTraversal(arbol.getRoot());

        System.out.println("\nPostorden:");
        arbol.posorderTraversal(arbol.getRoot());
    }
}