public class ArbolBin{
    Nodo raiz;
    
    public ArbolBin(){
        raiz=null;
    }
    
    public ArbolBin(Nodo r){
        raiz=r;
    }

    public void insertar(){
        
    }



    public void preorden(){
        System.out.println("Recorrido preorden");
        if (raiz == null) {
            System.out.println("El arbol esta vacio");
        }
        preordenRecursivo(raiz);
    }

    public void preordenRecursivo(Nodo nodo_actual){
        if (nodo_actual != null) {
            System.out.print(nodo_actual.getDato() + " ");
            preordenRecursivo(nodo_actual.getIzq());
            preordenRecursivo(nodo_actual.getDer());
        }
    }

    public void inorden(){
        System.out.println("\nRecorrido inorden");
        if (raiz == null) {
            System.out.println("El arbol esta vacio");
        }
        inordenRecursivo(raiz);
    }

    public void inordenRecursivo(Nodo nodo_actual){
        if (nodo_actual != null) {
            inordenRecursivo(nodo_actual.getIzq());
            System.out.print(nodo_actual.getDato() + " ");
            inordenRecursivo(nodo_actual.getDer());
        }
    }

    public void postorden(){
        System.out.println("\nRecorrido postorden");
        if (raiz == null) {
            System.out.println("El arbol esta vacio");
        }
        postordenRecursivo(raiz);
    }

    public void postordenRecursivo(Nodo nodo_actual){
        if (nodo_actual != null) {
            postordenRecursivo(nodo_actual.getIzq());
            postordenRecursivo(nodo_actual.getDer());
            System.out.print(nodo_actual.getDato() + " ");
        }
    }
}