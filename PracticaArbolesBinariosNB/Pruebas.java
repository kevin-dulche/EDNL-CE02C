public class Pruebas {
    public static void main(String[] args) {
        UnbalancedBinarySearchTree arbol = new UnbalancedBinarySearchTree();
        arbol.insert(10);
        arbol.insert(5);
        arbol.insert(15);
        arbol.insert(3);
        arbol.insert(7);
        arbol.insert(12);
        arbol.insert(18);
        arbol.insert(1);
        arbol.insert(4);
        arbol.insert(6);
        arbol.insert(8);
        arbol.insert(11);
        arbol.insert(13);
        arbol.insert(16);
        arbol.insert(20);
        arbol.insert(2);
        arbol.insert(9);
        arbol.insert(14);
        arbol.insert(17);
        arbol.insert(19);
        arbol.insert(21);
        System.out.println("Preorder Traversal");
        arbol.preorderTraversal(arbol.getRoot());
        System.out.println("\nInorder Traversal");
        arbol.inorderTraversal(arbol.getRoot());
        System.out.println("\nPosorder Traversal");
        arbol.posorderTraversal(arbol.getRoot());

        System.out.println("\nBuscando el valor 19");
        System.out.println(arbol.search(19));

        System.out.println("Eliminar el valor 18");
        arbol.delete(18);
        System.out.println("Preorder Traversal");
        arbol.preorderTraversal(arbol.getRoot());
    }
}
