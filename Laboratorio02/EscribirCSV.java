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
            for (Integer i = 0; i < listaN[j]; i++) {
                lista.insertar(i);
            }

            // Acceso
            startTime = System.nanoTime();
            lista.acceder(listaN[j]-1);
            endTime = System.nanoTime();
            
            long timeElapsedAccesoLista = endTime - startTime;
            System.out.println("Tiempo de ejecucion: " + timeElapsedAccesoLista + " nanosegundos");

            // Busqueda
            startTime = System.nanoTime();
            lista.buscar(listaN[j]);
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
            Pila<Integer> pilaTemp = new Pila<>();

            // Crear pila
            for (Integer i = 0; i < listaN[j]; i++) {
                pila.apilar(i);
            }

            // Acceso
            startTime = System.nanoTime();
            int finalPila = 0;

            while (!pila.estaVacia()) {
                finalPila = pila.desapilar();
                pilaTemp.apilar(finalPila);
            }

            endTime = System.nanoTime();

            long timeElapsedAccesoPila = endTime - startTime;
            
            while (!pilaTemp.estaVacia()) {
                pila.apilar(pilaTemp.desapilar());
            }

            // Busqueda
            startTime = System.nanoTime();
            int elemento_a_buscar = 0;

            while ((!pila.estaVacia()) && (pila.cima() != elemento_a_buscar)) {
                pilaTemp.apilar(pila.desapilar());
            }

            endTime = System.nanoTime();

            long timeElapsedBusquedaPila = endTime - startTime;

            while (!pilaTemp.estaVacia()) {
                pila.apilar(pilaTemp.desapilar());
            }

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
            Cola<Integer> colaTemp = new Cola<>();

            // Crear cola
            for (Integer i = 0; i < listaN[j]; i++) {
                cola.encolar(i);
            }

            // Acceso y Busqueda
            startTime = System.nanoTime();
            int ultimo_elemento = listaN[j];
            
            while (!cola.estaVacia()){
                ultimo_elemento = cola.desencolar();
                colaTemp.encolar(ultimo_elemento);
            }

            endTime = System.nanoTime();

            long timeElapsedAccesoCola = endTime - startTime;
            long timeElapsedBusquedaCola = timeElapsedAccesoCola;

            while (!colaTemp.estaVacia()) {
                cola.encolar(colaTemp.desencolar());
            }

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

            // long startTime = System.nanoTime();
            
            // for (Integer i = 0; i < 100; i++) {
            //     lista.insertar(i);
            // }
            
            // long endTime = System.nanoTime();
            
            // long timeElapsed = endTime - startTime;

            // System.out.println("Tiempo de ejecucion: " + timeElapsed + " nanosegundos");

            try {
                // Crear un BufferedWriter para escribir en el archivo
                BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));

                // Escribir encabezados
                writer.write("Estructura,Acceso,Busqueda,Insersion,Eliminacion\n");

                // Escribir datos
                writer.write("Lista," + timeElapsedAccesoLista + "ns," + timeElapsedBusquedaLista + "ns,"+ timeElapsedInsersionLista + "ns," + timeElapsedEliminacionLista + "ns\n");
                writer.write("Pila," + timeElapsedAccesoPila + "ns," + timeElapsedBusquedaPila + "ns,"+ timeElapsedInsersionPila + "ns," + timeElapsedEliminacionPila + "ns\n");
                writer.write("Cola," + timeElapsedAccesoCola + "ns," + timeElapsedBusquedaCola + "ns,"+ timeElapsedInsersionCola + "ns," + timeElapsedEliminacionCola + "ns\n");

                // Cerrar el BufferedWriter
                writer.close();

                System.out.println("Se ha escrito el archivo CSV '" + nombreArchivo + "' correctamente.");
            } catch (IOException e) {
                System.out.println("Error al escribir el archivo CSV '" + nombreArchivo + "': " + e.getMessage());
            }
        }
    }
}