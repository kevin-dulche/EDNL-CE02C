public class UnbalancedBinarySearchTree {
    private TreeNode root;

    public UnbalancedBinarySearchTree() {
        this.root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    // Implementar la inserción de un valor en el árbol
    public void insert(int val) {
        TreeNode nuevo = new TreeNode(val);
	
        // Implementación necesaria
        insertaRecursivo(nuevo, root);
    }

	public void insertaRecursivo(TreeNode nodo_nuevo, TreeNode nodo_actual){
        //Verificar si el nodo actual es null y la raiz es null entonces
        //En caso afirmativo poner el nodo nuevo como la raíz
        if (root == null) {
            root = nodo_nuevo;
        } else {
            //Si el nodo actual es distinto de null
            //Comparar el valor del nodo nuevo con el nodo actual
            //Hay que ver si es hoja (no tiene hijo izquierdo o derecho según el caso)
            //Si hay espacio (tiene un hijo izquierdo) se pone el nuevo nodo ahí
            //Si hay espacio (tiene un hijo derecho) se pone el nuevo nodo ahí
            //Si es menor hago recursividad en el hijo izquierdo para insertar
            //Si es mayor hago recursividad en el hijo derecho para insertar
            if (nodo_actual == null) {
                return; // Nodo actual es null, no podemos insertar aquí
            }
    
            if (nodo_nuevo.getVal() < nodo_actual.getVal()) {
                if (nodo_actual.getLeft() == null) {
                    nodo_actual.setLeft(nodo_nuevo); // Insertar a la izquierda si es posible
                } else {
                    insertaRecursivo(nodo_nuevo, nodo_actual.getLeft());
                }
            } else {
                if (nodo_actual.getRight() == null) {
                    nodo_actual.setRight(nodo_nuevo); // Insertar a la derecha si es posible
                } else {
                    insertaRecursivo(nodo_nuevo, nodo_actual.getRight());
                }
            }
        }
    }

    // Implementar la eliminación de un valor en el árbol
    public void delete(int val) {
        // Implementación necesaria
        eliminaRecursivo(val, root);
    }

    public boolean esHoja(TreeNode nodo){
        return nodo.getLeft() == null && nodo.getRight() == null;
    }

    public boolean tieneUnHijo(TreeNode nodo){
        return (nodo.getLeft() != null && nodo.getRight() == null) || (nodo.getLeft() == null && nodo.getRight() != null);
    }

    public boolean tieneDosHijos(TreeNode nodo){
        return nodo.getLeft() != null && nodo.getRight() != null;
    }

    public void eliminaRecursivo(int val, TreeNode nodo_actual){
        //Implementar la eliminación de un valor en el árbol
    }


    // Implementar la búsqueda de un valor en el árbol
    public boolean search(int val) {
        // Implementación necesaria
        return buscaRecursivo(val, root);
    }

    public boolean buscaRecursivo(int val, TreeNode nodo_actual){
        //Verificar si el nodo actual es null y la raiz es null entonces
        //En caso afirmativo poner el nodo nuevo como la raíz
        if (root == null) {
            return false;
        } else {
            //Si el nodo actual es distinto de null
            //Comparar el valor del nodo nuevo con el nodo actual
            //Si es igual regresar verdadero
            //Si es menor hago recursividad en el hijo izquierdo para buscar
            //Si es mayor hago recursividad en el hijo derecho para buscar
            if (nodo_actual == null) {
                return false; // Nodo actual es null, no podemos insertar aquí
            }
    
            if (val == nodo_actual.getVal()) {
                return true; // Encontramos el valor
            } else if (val < nodo_actual.getVal()) {
                return buscaRecursivo(val, nodo_actual.getLeft());
            } else {
                return buscaRecursivo(val, nodo_actual.getRight());
            }
        }
    }

    // Método para imprimir el árbol en orden
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.getLeft());
            System.out.print(root.getVal() + " ");
            inorderTraversal(root.getRight());
        }
    }

// Método para imprimir el árbol en orden
    public void preorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.getVal() + " ");
            preorderTraversal(root.getLeft());
            preorderTraversal(root.getRight());
        }
    }

// Método para imprimir el árbol en orden
    public void posorderTraversal(TreeNode root) {
        if (root != null) {
            posorderTraversal(root.getLeft());
            posorderTraversal(root.getRight());
            System.out.print(root.getVal() + " ");
        }
    }
}