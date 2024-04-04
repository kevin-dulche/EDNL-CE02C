public class Main {
    public static void main(String[] args) {
        BinaryTree arbol = new BinaryTree();
        arbol.insert(5);
        arbol.insert(2);
        arbol.insert(8);
        arbol.insert(1);
        arbol.insert(3);
        arbol.insert(7);
        arbol.insert(9);
        arbol.insert(15);
        arbol.insert(12);
        arbol.insert(18);

        System.out.println("Arbol original:");
        arbol.inorderTraversal(arbol.getRoot());

        BinaryTree copia = copiarArbol(arbol);
        System.out.println("\nArbol copia:");
        copia.inorderTraversal(copia.getRoot());

        System.out.println("\nCantidad de hojas del arbol original: " + contarHojas(arbol.getRoot()));
        System.out.println("Cantidad de hojas del arbol copia: " + contarHojas(copia.getRoot()));

        System.out.println("Altura del arbol original: " + calcularAltura(arbol));
        System.out.println("Altura del arbol copia: " + calcularAltura(copia));

        System.out.println("Máximo del arbol original: " + encontrarMaximo(arbol.getRoot()));
        System.out.println("Mínimo del arbol original: " + encontrarMinimo(arbol.getRoot()));

        System.out.println("Máximo del arbol copia: " + encontrarMaximo(copia.getRoot()));
        System.out.println("Mínimo del arbol copia: " + encontrarMinimo(copia.getRoot()));
    }

    public static BinaryTree copiarArbol(BinaryTree arbol) {
        if (arbol == null) {
            return null;
        }

        BinaryTree copia = new BinaryTree();
        copiarArbolRecursivo(arbol.getRoot(), copia);
        return copia;
    }

    public static void copiarArbolRecursivo(TreeNode arbol, BinaryTree copia){
        if (arbol == null) {
            return;
        }

        copia.insert(arbol.getVal());
        copiarArbolRecursivo(arbol.getLeft(), copia);
        copiarArbolRecursivo(arbol.getRight(), copia);
    }

    public static int contarHojas(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }
        
        int leftCount = contarHojas(root.getLeft());
        int rightCount = contarHojas(root.getRight());
        
        return leftCount + rightCount;
    }

    public static int calcularAltura(BinaryTree arbol) {
        return calcularAlturaRecursivo(arbol.getRoot());
    }

    public static int calcularAlturaRecursivo(TreeNode nodo) {
        if (nodo == null) {
            return 0;
        }
        
        int alturaIzquierda = calcularAlturaRecursivo(nodo.getLeft());
        int alturaDerecha = calcularAlturaRecursivo(nodo.getRight());
        
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    public static int encontrarMaximo(TreeNode nodo) {
        if (nodo == null) {
            throw new IllegalArgumentException("El árbol está vacío");
        }
        
        if (nodo.getRight() == null) {
            return nodo.getVal();
        }
        
        return encontrarMaximo(nodo.getRight());
    }

    public static int encontrarMinimo(TreeNode nodo) {
        if (nodo == null) {
            throw new IllegalArgumentException("El árbol está vacío");
        }
        
        if (nodo.getLeft() == null) {
            return nodo.getVal();
        }
        
        return encontrarMinimo(nodo.getLeft());
    }
}