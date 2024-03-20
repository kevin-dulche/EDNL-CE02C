import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirCSV {
    public static void main(String[] args) {
        // Definir la lista de enteros
        int[] listaN = {50, 500, 5000};

        // Iterar sobre la lista y escribir un archivo CSV para cada elemento
        for (int j = 0; j < listaN.length; j++) {
            // Construir el nombre del archivo CSV basado en el elemento actual de la lista
            String nombreArchivo = "PeorEscenario" + listaN[j] + ".csv";

            long startTime;
            long endTime;

            // Listas
            Lista<Integer> lista = new Lista<>();

            // Crear lista
            for (int i = 0; i < listaN[j]; i++) {
                lista.insertar(i);
            }

            // Acceso
            startTime = System.nanoTime();
            lista.acceder(listaN[j]-2);
            endTime = System.nanoTime();
            
            long timeElapsedAccesoLista = endTime - startTime;
            System.out.println("Tiempo de ejecucion: " + timeElapsedAccesoLista + " nanosegundos");

            // Busqueda
            startTime = System.nanoTime();
            lista.buscar(listaN[j]-1);
            endTime = System.nanoTime();

            long timeElapsedBusquedaLista = endTime - startTime;
            
            // Insersion
            startTime = System.nanoTime();
            lista.insertar(123);
            endTime = System.nanoTime();

            long timeElapsedInsersionLista = endTime - startTime;
            
            // Eliminacion
            startTime = System.nanoTime();
            lista.eliminar(listaN[j]);
            endTime = System.nanoTime();

            long timeElapsedEliminacionLista = endTime - startTime;


            // Pilas
            Pila<Integer> pila = new Pila<>();

            // Crear pila
            for (Integer i = 0; i < listaN[j]; i++) {
                pila.apilar(i);
            }

            // Acceso
            startTime = System.nanoTime();
            pila.cima();
            endTime = System.nanoTime();

            long timeElapsedAccesoPila = endTime - startTime;

            // Insersion
            startTime = System.nanoTime();
            pila.apilar(123);
            endTime = System.nanoTime();

            long timeElapsedInsersionPila = endTime - startTime;

            // Eliminacion
            startTime = System.nanoTime();
            pila.desapilar();
            endTime = System.nanoTime();

            long timeElapsedEliminacionPila = endTime - startTime;

            // Colas
            Cola<Integer> cola = new Cola<>();

            // Crear cola
            for (Integer i = 0; i < listaN[j]; i++) {
                cola.encolar(i);
            }

            // Acceso
            startTime = System.nanoTime();
            cola.frente();
            endTime = System.nanoTime();

            long timeElapsedAccesoCola = endTime - startTime;

            // Insersion
            startTime = System.nanoTime();
            cola.encolar(123);
            endTime = System.nanoTime();

            long timeElapsedInsersionCola = endTime - startTime;

            // Eliminacion
            startTime = System.nanoTime();
            cola.desencolar();
            endTime = System.nanoTime();

            long timeElapsedEliminacionCola = endTime - startTime;


            try {
                // Crear un BufferedWriter para escribir en el archivo
                BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));

                // Escribir encabezados
                writer.write("Estructura,Acceso,Busqueda,Insersion,Eliminacion\n");

                // Escribir datos
                writer.write("Lista," + timeElapsedAccesoLista + "ns," + timeElapsedBusquedaLista + "ns,"+ timeElapsedInsersionLista + "ns," + timeElapsedEliminacionLista + "ns\n");
                writer.write("Pila," + timeElapsedAccesoPila + "ns," + "-,"+ timeElapsedInsersionPila + "ns," + timeElapsedEliminacionPila + "ns\n");
                writer.write("Cola," + timeElapsedAccesoCola + "ns," + "-,"+ timeElapsedInsersionCola + "ns," + timeElapsedEliminacionCola + "ns\n");

                // Cerrar el BufferedWriter
                writer.close();

                System.out.println("Se ha escrito el archivo CSV '" + nombreArchivo + "' correctamente.");
            } catch (IOException e) {
                System.out.println("Error al escribir el archivo CSV '" + nombreArchivo + "': " + e.getMessage());
            }
        }
    }
}