public class Nodo<T> {
    public T dato;
    public Nodo<T> siguiente;

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public T obtenerDato() {
        return dato;
    }

    public Nodo<T> obtenerSiguiente() {
        return siguiente;
    }

    public void establecerSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}