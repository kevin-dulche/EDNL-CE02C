public class Lista<T> {

    public Nodo<T> primero;
    public Nodo<T> ultimo;

    public void insertar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (primero == null) {
            primero = ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }

    public T eliminar(int posicion) {
        if (posicion < 0 || posicion >= size()) {
            return null;
        }

        if (posicion == 0) {
            return eliminarPrimero();
        } else if (posicion == size() - 1) {
            return eliminarUltimo();
        } else {
            Nodo<T> anterior = obtenerNodo(posicion - 1);
            Nodo<T> actual = anterior.siguiente;
            anterior.siguiente = actual.siguiente;
            return actual.dato;
        }
    }

    private T eliminarPrimero() {
        if (primero == null) {
            return null;
        }
        T dato = primero.dato;
        primero = primero.siguiente;
        if (primero == null) {
            ultimo = null;
        }
        return dato;
    }

    private T eliminarUltimo() {
        if (ultimo == null) {
            return null;
        }
        T dato = ultimo.dato;
        if (primero == ultimo) {
            primero = ultimo = null;
        } else {
            Nodo<T> actual = primero;
            while (actual.siguiente != ultimo) {
                actual = actual.siguiente;
            }
            actual.siguiente = null;
            ultimo = actual;
        }
        return dato;
    }

    public boolean buscar(T dato) {
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public T acceder(int posicion) {
        if (posicion < 0 || posicion >= size()) {
            return null;
        }
        Nodo<T> actual = primero;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    public int size() {
        int size = 0;
        Nodo<T> actual = primero;
        while (actual != null) {
            size++;
            actual = actual.siguiente;
        }
        return size;
    }

    public
    Nodo<T> obtenerNodo(int posicion) {
        if (posicion < 0 || posicion >= size()) {
            return null;
        }
        Nodo<T> actual = primero;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Nodo<T> actual = primero;
        while (actual != null) {
            sb.append(actual.dato);
            if (actual.siguiente != null) {
                sb.append(", ");
            }
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}
