import java.util.HashSet;
import java.util.Random;

public class Pruebas {
    public static void main(String[] args) {
        UnbalancedBinarySearchTree arbol = new UnbalancedBinarySearchTree();
        
        Random rand = new Random();
        HashSet<Integer> numerosGenerados = new HashSet<>();

        // Número de elementos aleatorios únicos que deseas agregar al árbol
        // int cantidadElementos = 2147483647;
        int cantidadElementos = 100000;

        // Medir el tiempo que tarda en agregar elementos al árbol en segundos
        long startTimeAgregar = System.nanoTime();
        // Agregar números aleatorios únicos al árbol
        while (numerosGenerados.size() < cantidadElementos) {
            int valor = rand.nextInt(cantidadElementos); // Genera números aleatorios entre 0 y 99
            if (!numerosGenerados.contains(valor)) {
                arbol.insert(valor);
                numerosGenerados.add(valor);
                System.out.println("Agregando " + valor + "\t al arbol");
            }
        }
        long endTimeAgregar = System.nanoTime();

        long durationAgregar = (endTimeAgregar - startTimeAgregar);

        double durationAgregarSeconds = durationAgregar / 1_000_000_000.0;
        System.out.println("Tiempo de agregar: " + durationAgregarSeconds + " segundos");

        // Medir el tiempo que tarda en buscar elementos al árbol
        // Buscar un número en el árbol
        int numeroABuscar = 54321;
        long startTime = System.nanoTime();
        System.out.println("Buscando " + numeroABuscar + " ten el arbol");
        System.out.println(arbol.search(numeroABuscar));
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);

        System.out.println("Tiempo de busqueda: " + duration + " nanosegundos");

        // Imprimir el árbol
        // System.out.println("Preorden:");
        // arbol.preorderTraversal(arbol.getRoot());
        
        // System.out.println("\nInorden:");
        // arbol.inorderTraversal(arbol.getRoot());

        // System.out.println("\nPostorden:");
        // arbol.posorderTraversal(arbol.getRoot());
    }
}