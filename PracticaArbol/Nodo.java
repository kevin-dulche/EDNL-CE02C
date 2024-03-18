/**
 * Nodo
 */
public class Nodo {
    private int dato;
    private Nodo izq;
    private Nodo der;

    // Constructor
    public Nodo(int dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }

    // Getters
    public int getDato() {
        return dato;
    }

    public Nodo getIzq() {
        return izq;
    }

    public Nodo getDer() {
        return der;
    }

    // Setters
    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }
}