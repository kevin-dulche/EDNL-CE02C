public class Main {
    public static void main(String[] args) {
        Nodo raiz = new Nodo(1);
        Nodo nodo1 = new Nodo(2);
        Nodo nodo2 = new Nodo(3);
        Nodo nodo3 = new Nodo(4);
        Nodo nodo4 = new Nodo(5);

        raiz.setIzq(nodo1);
        raiz.setDer(nodo2);
        nodo1.setIzq(nodo3);
        nodo1.setDer(nodo4);
    }
}
