// 
public class Examen_EnClase {

    // * Primera parte
    // * Ejercicio 3
    
    /*
     * Método que calcula la altura de un árbol binario.
     * @param arbol El árbol binario del que se quiere calcular la altura.
     * @return La altura del árbol binario.
     */
    public static int calcularAltura(BinaryTree arbol) {
        return calcularAlturaRecursivo(arbol.getRoot());
    }

    /*
     * Método que calcula la altura de un árbol binario de manera recursiva.
     * @param nodo El nodo actual del árbol binario.
     * @return La altura del árbol binario.
     */
    public static int calcularAlturaRecursivo(TreeNode nodo) {
        if (nodo == null) {
            return 0;
        }
        
        int alturaIzquierda = calcularAlturaRecursivo(nodo.getLeft());
        int alturaDerecha = calcularAlturaRecursivo(nodo.getRight());
        
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    // * Segunda parte
    // * Ejercicio 1

    /*
     * Método que verifica si dos árboles binarios son equivalentes.
     * @param arbol1 El primer árbol binario.
     * @param arbol2 El segundo árbol binario.
     * @return true si los árboles son equivalentes, false en caso contrario.
     */
    public static boolean verificarEquivalencia(BinaryTree arbol1, BinaryTree arbol2) {
        return verificarEquivalenciaRecursivo(arbol1.getRoot(), arbol2.getRoot());
    }

    /*
     * Método que verifica si dos árboles binarios son equivalentes de manera recursiva.
     * @param nodo1 El nodo actual del primer árbol binario.
     * @param nodo2 El nodo actual del segundo árbol binario.
     * @return true si los árboles son equivalentes, false en caso contrario.
     */
    public static boolean verificarEquivalenciaRecursivo(TreeNode nodo1, TreeNode nodo2) {
        if (nodo1 == null && nodo2 == null) {
            return true;
        }
        
        if (nodo1 == null || nodo2 == null) {
            return false;
        }
        
        if (nodo1.getVal() != nodo2.getVal()) {
            return false;
        }
        
        boolean izquierdaEquivalente = verificarEquivalenciaRecursivo(nodo1.getLeft(), nodo2.getLeft());
        boolean derechaEquivalente = verificarEquivalenciaRecursivo(nodo1.getRight(), nodo2.getRight());
        
        return izquierdaEquivalente && derechaEquivalente;
    }

    public static void main(String[] args) {
        // Crear dos árboles binarios
        BinaryTree arbol1 = new BinaryTree();
        arbol1.insert(10);
        arbol1.insert(5);
        arbol1.insert(15);
        arbol1.insert(3);
        arbol1.insert(7);
        arbol1.insert(12);
        arbol1.insert(17);

        
        BinaryTree arbol2 = new BinaryTree();
        arbol2.insert(10);
        arbol2.insert(5);
        arbol2.insert(15);
        arbol2.insert(3);
        arbol2.insert(7);
        arbol2.insert(12);
        arbol2.insert(17);
        
        System.out.println("Recorrido en preorden del arbol 1:");
        arbol1.preorderTraversal(arbol1.getRoot());
        
        System.out.println("\nRecorrido en preorden del arbol 2:");
        arbol2.preorderTraversal(arbol2.getRoot());
        
        System.out.println();
        System.out.println("Altura del arbol 1: " + calcularAltura(arbol1)); // Debe imprimir 3
        System.out.println("Es equivalente el arbol 1 y 2? " + verificarEquivalencia(arbol1, arbol2)); // Debe imprimir true

        System.out.println("\nInsertando un nodo en el arbol 2...");
        arbol1.insert(20);
        System.out.println("Altura del arbol 1: " + calcularAltura(arbol1)); // Debe imprimir 4
        System.out.println("Recorrido en preorden del arbol 2:");
        arbol1.preorderTraversal(arbol1.getRoot());
        System.out.println("\nEs equivalente el arbol 1 y 2? " + verificarEquivalencia(arbol1, arbol2)); // Debe imprimir false
    }
}