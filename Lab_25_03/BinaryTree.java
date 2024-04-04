class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    // Método auxiliar para imprimir el árbol
    private void printTree(TreeNode node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.val);
            printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    // Método público para iniciar la impresión del árbol
    public void printTree() {
        printTree(root, "", false);
    }
}