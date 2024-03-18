public class Pila<T> {
    private Nodo<T> cima;
    private int tamanio;

    public Pila() {
        cima = null;
        tamanio = 0;
    }

    public void apilar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (cima == null) {
            cima = nuevoNodo;
        } else {
            nuevoNodo.establecerSiguiente(cima);
            cima = nuevoNodo;
        }
        tamanio++;
    }

    public T desapilar() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        T datoDesapilado = cima.obtenerDato();
        cima = cima.obtenerSiguiente();
        tamanio--;
        return datoDesapilado;
    }

    public T cima() {
        if (estaVacia()) {
            System.out.println("La pila esta vacia");
        }
        return cima.obtenerDato();
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public int tamanio() {
        return tamanio;
    }
}