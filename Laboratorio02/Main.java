/*public class Main {
    public static void main(String[] args) {

        long startTime;
        long endTime;

        // Listas
        Lista<Integer> lista = new Lista<>();

        // Crear lista
        for (Integer i = 0; i < 50; i++) {
            lista.insertar(i);
        }


        // Acceso
        startTime = System.nanoTime();
        lista.acceder(49);
        endTime = System.nanoTime();
        
        long timeElapsedAccesoLista = endTime - startTime;

        // Busqueda
        startTime = System.nanoTime();
        lista.buscar(50);
        endTime = System.nanoTime();

        long timeElapsedBusquedaLista = endTime - startTime;
        
        // Insersion
        startTime = System.nanoTime();
        lista.insertar(50);
        endTime = System.nanoTime();

        long timeElapsedInsersionLista = endTime - startTime;
        
        // Eliminacion
        startTime = System.nanoTime();
        lista.eliminar(50);
        endTime = System.nanoTime();

        long timeElapsedEliminacionLista = endTime - startTime;


        // Pilas
        Pila<Integer> pila = new Pila<>();
        Pila<Integer> pilaTemp = new Pila<>();

        // Crear pila
        for (Integer i = 0; i < 50; i++) {
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

        while ((pila.cima() != elemento_a_buscar) && (!pila.estaVacia())) {
            pilaTemp.apilar(pila.desapilar());
        }

        endTime = System.nanoTime();

        long timeElapsedBusquedaPila = endTime - startTime;

        while (!pilaTemp.estaVacia()) {
            pila.apilar(pilaTemp.desapilar());
        }

        // Insersion
        startTime = System.nanoTime();
        pila.apilar(100);
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
        for (Integer i = 0; i < 50; i++) {
            cola.encolar(i);
        }

        // Acceso y Busqueda
        startTime = System.nanoTime();
        int ultimo_elemento = 50;
        
        for (Integer i = 0; i < 50; i++) {
            ultimo_elemento = cola.desencolar();
            colaTemp.encolar(ultimo_elemento);
        }

        endTime = System.nanoTime();

        long timeElapsedAccesoCola = endTime - startTime;

        while (!colaTemp.estaVacia()) {
            cola.encolar(colaTemp.desencolar());
        }

        // Insersion
        startTime = System.nanoTime();
        cola.encolar(100);
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

    }
}
*/