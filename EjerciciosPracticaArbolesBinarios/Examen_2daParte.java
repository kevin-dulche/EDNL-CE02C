import java.util.Queue;

public class Examen_2daParte {

    // * Primera parte
    // * Ejercicio 7


    /**
     * Método para verificar si un árbol binario es un árbol de búsqueda
     * @param tree
     * @return
     */
    public static boolean esArbolDeBusqueda(BinaryTree tree) {
        return esArbolDeBusquedaRec(tree.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Método recursivo para verificar si un árbol binario es un árbol de búsqueda
     * @param node
     * @param minValue
     * @param maxValue
     * @return
     */
    private static boolean esArbolDeBusquedaRec(TreeNode node, int minValue, int maxValue) {
        // Caso base: si el nodo es nulo, es un árbol de búsqueda válido
        if (node == null) {
            return true;
        }

        // Verificar si el valor del nodo actual está dentro del rango permitido
        if (node.getVal() < minValue || node.getVal() > maxValue) {
            return false;
        }

        // Verificar recursivamente los subárboles izquierdo y derecho
        return esArbolDeBusquedaRec(node.getLeft(), minValue, node.getVal() - 1)
                && esArbolDeBusquedaRec(node.getRight(), node.getVal() + 1, maxValue);
    }

    // * Segunda parte
    // * Ejercicio 3

    /**
     * Método para imprimir el camino desde la raíz hasta un nodo con un valor
     * @param root
     * @param valor
     * @return
     */
    public static boolean imprimirCamino(TreeNode root, int valor) {
        Queue<TreeNode> cola = new java.util.LinkedList<>();
        return imprimirCaminoRec(root, valor, cola);
    }

    /**
     * Método recursivo para imprimir el camino desde la raíz hasta un nodo con un valor
     * @param nodoActual
     * @param valor
     * @param cola
     * @return
     */
    private static boolean imprimirCaminoRec(TreeNode nodoActual, int valor, Queue<TreeNode> cola) {
        // Caso base: si el nodo es nulo, no se encontró el valor
        if (nodoActual == null) {
            return false;
        }

        // Agregar el nodo actual a la cola
        cola.add(nodoActual);

        // Verificar si el nodo actual contiene el valor buscado
        if (nodoActual.getVal() == valor) {
            // Imprimir el camino desde la raíz hasta el nodo actual
            for (TreeNode n : cola) {
                System.out.print(n.getVal() + " -> ");
            }
            return true;
        }

        // Verificar recursivamente los subárboles izquierdo y derecho
        if (imprimirCaminoRec(nodoActual.getLeft(), valor, cola) || imprimirCaminoRec(nodoActual.getRight(), valor, cola)) {
            return true;
        }

        // Eliminar el nodo actual de la cola antes de regresar
        cola.remove(nodoActual);
        return false;
    }

    public static void main(String[] args) {
        // Crear dos árboles binarios
        BinaryTree arbol1 = new BinaryTree();
        arbol1.insert(10);
        arbol1.insert(5);
        arbol1.insert(15);
        arbol1.insert(2);
        arbol1.insert(7);
        arbol1.insert(6);
        arbol1.insert(9);
        arbol1.insert(20);

        System.out.println("Recorrido en preorden del arbol 1:");
        arbol1.preorderTraversal(arbol1.getRoot());

        System.out.println("\nEl arbol 1 es un arbol de busqueda: " + esArbolDeBusqueda(arbol1));

        boolean camino = imprimirCamino(arbol1.getRoot(), 9);
        if (camino == false) {
            System.out.println("No se encontro el valor en el arbol 1");
        }
    }
}