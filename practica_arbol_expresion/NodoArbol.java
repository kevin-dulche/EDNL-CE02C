public class NodoArbol {
    private String dato;
    private NodoArbol izq;
    private NodoArbol der;

    public NodoArbol(String dato, NodoArbol izq, NodoArbol der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }

    public NodoArbol(String dato){
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public void setIzq(NodoArbol izq) {
        this.izq = izq;
    }

    public void setDer(NodoArbol der) {
        this.der = der;
    }

    public String getDato() {
        return dato;
    }

    public NodoArbol getIzq() {
        return izq;
    }

    public NodoArbol getDer() {
        return der;
    }
}