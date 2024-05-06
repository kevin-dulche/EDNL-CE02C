/*
 * Sección 2: Montículo (Heap)
 * Pregunta b (25 puntos):
    Crea un programa que une dos montículos en uno solo manteniendo la propiedad de orden. Imprime el nuevo árbol por niveles.
 */

import java.util.PriorityQueue;

public class UnirHeaps {

    // Método para unir dos montículos manteniendo la propiedad de orden
    public static PriorityQueue<Integer> mergeHeaps(PriorityQueue<Integer> heap1, PriorityQueue<Integer> heap2) {
        // Crear un nuevo montículo
        PriorityQueue<Integer> unionHeap = new PriorityQueue<>();
        // Agregar todos los elementos de los montículos originales al nuevo montículo
        unionHeap.addAll(heap1);
        // Agregar todos los elementos de los montículos originales al nuevo montículo
        unionHeap.addAll(heap2);
        // Devolver el nuevo montículo
        return unionHeap;
    }

    // Método para imprimir el árbol por niveles
    public static void imprimirPorNivel(PriorityQueue<Integer> heap) {
        // Imprimir los elementos del montículo por niveles
        while (!heap.isEmpty()) {
            System.out.print(heap.poll() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Crear dos montículos
        PriorityQueue<Integer> heap1 = new PriorityQueue<>();
        PriorityQueue<Integer> heap2 = new PriorityQueue<>();

        // Agregar elementos a los montículos
        // heap1: 1, 3, 6, 9
        heap1.add(3);
        heap1.add(6);
        heap1.add(9);

        // Copiar el montículo 1
        PriorityQueue<Integer> heap1Copia = new PriorityQueue<>(heap1);

        // Imprimir el primer montículo por niveles
        System.out.println("Monticulo 1 por niveles:");
        imprimirPorNivel(heap1Copia);

        // heap2: 2, 5, 8
        heap2.add(2);
        heap2.add(5);
        heap2.add(8);

        // Copiar el montículo 2
        PriorityQueue<Integer> heap2Copia = new PriorityQueue<>(heap2);

        // Imprimir el segundo montículo por niveles
        System.out.println("Monticulo 2 por niveles:");
        imprimirPorNivel(heap2Copia);

        // Unir los montículos
        PriorityQueue<Integer> unionHeaps = mergeHeaps(heap1, heap2);

        // Imprimir el nuevo montículo por niveles
        System.out.println("Nuevo monticulo unido por niveles:");
        imprimirPorNivel(unionHeaps);

    }
}
