import java.util.Random;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // Definir la lista de enteros
        int[] listaN = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216};

        for (int i : listaN) {
            // Crear un objeto de la clase AVLTree
            AVLTree arbolAVL = new AVLTree();

            // Crear un objeto de la clase TreeMap
            TreeMap<Integer, String> RojoNegro = new TreeMap<>(); 

            // Crear un objeto de la clase Random
            Random random = new Random();
            /*Prueba de inserción:
            Insertar un conjunto de N elementos aleatorios en ambos tipos de árboles.
            Medir el tiempo de inserción total para cada tipo de árbol.
            Repetir la prueba con diferentes valores de N (por ejemplo, 100, 1000, 10000, etc.) y registrar los resultados.
            */

            // Crea un conjunto de N elementos aleatorios
            int[] arreglo = new int[i];
            for (int j = 0; j < i; j++) {
                arreglo[j] = random.nextInt(Integer.MAX_VALUE);
            }

            // Medir el tiempo de inserción total para cada tipo de árbol
            long tiempoInicioInsercionAVL = System.currentTimeMillis();
            for (int j = 0; j < i; j++) {
                arbolAVL.insert(arreglo[j]);
            }
            long tiempoFinalInsercionAVL = System.currentTimeMillis();
            long tiempoTotalInsercionAVL = tiempoFinalInsercionAVL - tiempoInicioInsercionAVL;

            long tiempoInicioInsercionRojoNegro = System.currentTimeMillis();
            for (int j = 0; j < i; j++) {
                RojoNegro.put(arreglo[j], "Elemento " + arreglo[j]);
            }
            long tiempoFinalInsercionRojoNegro = System.currentTimeMillis();
            long tiempoTotalInsercionRojoNegro = tiempoFinalInsercionRojoNegro - tiempoInicioInsercionRojoNegro;

//          Prueba de eliminación:
//          Insertar un conjunto de N elementos aleatorios en ambos tipos de árboles.
//          Eliminar un subconjunto de M elementos aleatorios en cada tipo de árbol.
//          Medir el tiempo de eliminación total para cada tipo de árbol.
//          Repetir la prueba con diferentes valores de N y M y registrar los resultados.

            // Crear un conjunto de M elementos aleatorios
            int M = i / 10;
            int[] arregloM = new int[M];
            for (int j = 0; j < M; j++) {
                arregloM[j] = arreglo[random.nextInt(i)];
            }

            // Medir el tiempo de eliminación total para cada tipo de árbol
            long tiempoInicioEliminacionAVL = System.currentTimeMillis();
            for (int j = 0; j < M; j++) {
                arbolAVL.delete(arregloM[j]);
            }
            long tiempoFinalEliminacionAVL = System.currentTimeMillis();
            long tiempoTotalEliminacionAVL = tiempoFinalEliminacionAVL - tiempoInicioEliminacionAVL;

            long tiempoInicioEliminacionRojoNegro = System.currentTimeMillis();
            for (int j = 0; j < M; j++) {
                RojoNegro.remove(arregloM[j]);
            }
            long tiempoFinalEliminacionRojoNegro = System.currentTimeMillis();
            long tiempoTotalEliminacionRojoNegro = tiempoFinalEliminacionRojoNegro - tiempoInicioEliminacionRojoNegro;
                
            // Imprimir los resultados
            System.out.println("N = " + i);
            System.out.println("Tiempo de insercion AVL: " + tiempoTotalInsercionAVL + " ms");
            System.out.println("Tiempo de insercion RojoNegro: " + tiempoTotalInsercionRojoNegro + " ms");
            System.out.println("Tiempo de eliminacion AVL: " + tiempoTotalEliminacionAVL + " ms");
            System.out.println("Tiempo de eliminacion RojoNegro: " + tiempoTotalEliminacionRojoNegro + " ms");
            System.out.println();
        }
    }
}