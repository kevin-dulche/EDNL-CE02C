public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamanio;

    // Constructor
    public Cola() {
        frente = null;
        fin = null;
        tamanio = 0;
    }

    // Clase interna para representar un nodo
    private static class Nodo<T> {
        private T dato;
        private Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // Método para agregar un elemento al final de la cola
    public void encolar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (estaVacia()) {
            frente = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
        }
        fin = nuevoNodo;
        tamanio++;
    }

    // Método para retirar y devolver el elemento del frente de la cola
    public T desencolar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía");
        }
        T datoDesencolado = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        tamanio--;
        return datoDesencolado;
    }

    // Método para obtener el elemento del frente de la cola sin retirarlo
    public T frente() {
        if (estaVacia()) {
            System.out.println("La cola está vacía");
        }
        return frente.dato;
    }

    // Método para comprobar si la cola está vacía
    public boolean estaVacia() {
        return tamanio == 0;
    }

    // Método para obtener el tamanio de la cola
    public int tamanio() {
        return tamanio;
    }
}